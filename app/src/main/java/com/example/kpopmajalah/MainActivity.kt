package com.example.kpopmajalah

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<ClipData.Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.kpopmajalah_list)
        initDATA()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter( this,  items)
    }

    private fun initDATA(){
        val name = resources.getStringArray(R.array.kpopmajalah_name)
        val image = resources.obtainTypedArray(R.array.kpopmajalah_image)

        items.clear()

        for (i in name.indices) {
            items.add(
                ClipData.Item(name[i],
                    image.getResourceId(i, 0).toString()
                )
            )

        }
        image.recycle()
    }
}

package com.tonynowater.librarytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonynowater.librarytest.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_main.rv

class StickItemBelowToolBarWhileDraggingActivity :
    AppCompatActivity(R.layout.activity_stick_item_below_toolbar) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter =
            MyAdapter(data = arrayOfNulls(56))
    }
}
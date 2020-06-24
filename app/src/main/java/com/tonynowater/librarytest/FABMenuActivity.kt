package com.tonynowater.librarytest

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fab_menu_motion_scene_1.fab_item_1
import kotlinx.android.synthetic.main.activity_fab_menu_motion_scene_1.fab_item_2
import kotlinx.android.synthetic.main.activity_fab_menu_motion_scene_1.fab_item_3
import kotlinx.android.synthetic.main.activity_fab_menu_motion_scene_1.ml

class FABMenuActivity : AppCompatActivity(R.layout.activity_fab_menu_motion_scene_1) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ml.setOnTouchListener { v, event ->
            closeMenu()
            true
        }

        fab_item_1.setOnClickListener {
            Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show()
            closeMenuWithDelay()
        }

        fab_item_2.setOnClickListener {
            Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show()
            closeMenuWithDelay()
        }

        fab_item_3.setOnClickListener {
            Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show()
            closeMenuWithDelay()
        }
    }

    private fun closeMenuWithDelay() {
        Handler().postDelayed({ ml.transitionToStart() }, 500)
    }

    private fun closeMenu() {
        ml.transitionToStart()
    }
}
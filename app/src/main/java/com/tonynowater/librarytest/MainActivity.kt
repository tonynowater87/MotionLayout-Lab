package com.tonynowater.librarytest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonynowater.librarytest.adapter.MenuAdapter
import kotlinx.android.synthetic.main.activity_main.rv

class MainActivity : AppCompatActivity() {

    private val items: ArrayList<String> by lazy {
        arrayListOf(
            getString(R.string.item1),
            getString(R.string.item2),
            getString(R.string.item3)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.app_name)

        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter = MenuAdapter(items).apply {

            val mainActivity = this@MainActivity

            this.onClickListener = { position ->
                val intent = when (position) {
                    0 -> Intent(mainActivity, StickItemBelowToolBarWhileDraggingActivity::class.java)
                    1 -> Intent(mainActivity, PullToRefreshActivity::class.java)
                    2 -> Intent(mainActivity, FABMenuActivity::class.java)
                    else -> null
                }

                intent?.also {
                    startActivity(it)
                }
            }
        }
    }
}
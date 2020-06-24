package com.tonynowater.librarytest

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonynowater.librarytest.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_pull_to_refresh.ml
import kotlinx.android.synthetic.main.activity_pull_to_refresh.rv

class PullToRefreshActivity : AppCompatActivity(R.layout.activity_pull_to_refresh) {

    private val handler = Handler {
        Log.d("[DEBUG]", "handler:$it")
        Handler().postDelayed({ ml.transitionToStart() }, 1000)
        true
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv.layoutManager = LinearLayoutManager(applicationContext)
        rv.adapter = MyAdapter(data = arrayOfNulls(56))

        ml.setTransitionListener(object : TransitionAdapter() {

            var startId = -1
            var endId = -1

            override fun onTransitionStarted(
                p0: MotionLayout,
                startResourceId: Int,
                endResourceId: Int
            ) {
                startId = startResourceId
                endId = endResourceId
                Log.d(
                    "[Tony]",
                    "[onTransitionStarted] startResourceId:$startResourceId, endResourceId:$endResourceId"
                )
            }

            override fun onTransitionChange(
                p0: MotionLayout,
                startResourceId: Int,
                endResourceId: Int,
                progress: Float
            ) {
                Log.d(
                    "[Tony]",
                    "[onTransitionChange] startResourceId:$startResourceId, endResourceId:$endResourceId, progress:$progress"
                )
            }

            override fun onTransitionCompleted(p0: MotionLayout, completedResourceId: Int) {
                when (completedResourceId) {
                    startId -> {
                        Log.d("[Tony]", "onTransitionCompleted to Start State")
                    }
                    endId -> {
                        Log.d("[Tony]", "onTransitionCompleted to End State")
                        handler.obtainMessage().apply {
                            handler.sendMessageDelayed(this, 1000L)
                        }
                    }
                    else -> Log.d("[Tony]", "onTransitionCompleted to Unknown State")
                }
            }
        })
    }
}
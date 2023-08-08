package com.example.digitekademoappapplirossel

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.viewpager2.widget.ViewPager2
import com.example.digitekademoappapplirossel.adapters.ArticlePagerAdapter
import com.example.digitekademoappapplirossel.assets.bodyHTML
import com.example.digitekademoappapplirossel.interfaces.WebviewPositionCallback

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val articleList = listOf(bodyHTML, bodyHTML, bodyHTML)
        val nestedScrollView = findViewById<NestedScrollView>(R.id.articleDetailNestedScrollView)

        val positionCallback = object : WebviewPositionCallback {
            override fun onPositionChanged(position: Int) {
                Log.d("ScrollPosition", "Absolute position of WebView: $position")
            }
        }

        viewPager.adapter = ArticlePagerAdapter(articleList, positionCallback)




        // Detect the position of the WebView inside the NestedScrollView and log it
        nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, _ ->
            val viewPagerTop = viewPager.top
            val absolutePosition = scrollY + viewPagerTop
            Log.d("ScrollPosition", "Absolute position of ViewPager2: $absolutePosition")
        }
    }
}
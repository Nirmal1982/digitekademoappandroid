package com.example.digitekademoappapplirossel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ViewPager>(R.id.view_pager).apply {
            adapter = DemoAppViewPagerAdapter(supportFragmentManager)
        }
    }
}

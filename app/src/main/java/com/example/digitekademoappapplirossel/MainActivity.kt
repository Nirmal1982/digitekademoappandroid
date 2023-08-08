package com.example.digitekademoappapplirossel

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.digitekademoappapplirossel.adapters.ArticlePagerAdapter
import com.example.digitekademoappapplirossel.assets.bodyHTML

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val articleList = listOf(bodyHTML, bodyHTML, bodyHTML)

        viewPager.adapter = ArticlePagerAdapter(articleList)
    }
}
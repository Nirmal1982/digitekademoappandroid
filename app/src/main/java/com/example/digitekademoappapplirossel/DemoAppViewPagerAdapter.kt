package com.example.digitekademoappapplirossel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class DemoAppViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val total = 10

    override fun getCount(): Int = total

    override fun getItem(position: Int): Fragment = ViewPagerFragment.newInstance()
}
package com.jweihao.jdemo.ui.activity.layout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jweihao.jdemo.adapter.FragPagerAdapter
import com.wh.customcontrol.R
import kotlinx.android.synthetic.main.activity_catvr.*

class CATVRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catvr)

        //将viewPager和Fragment绑定
        val fragPagerAdapter = FragPagerAdapter(supportFragmentManager)
        viewpager.setAdapter(fragPagerAdapter)
        tablayout.setupWithViewPager(viewpager)
    }
}

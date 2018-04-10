package com.jweihao.jdemo.ui.activity.book.hero

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jweihao.jdemo.ui.activity.animation.AnimationActivity
import com.jweihao.jdemo.ui.activity.book.hero.custom.CustomActivity
import com.jweihao.jdemo.ui.activity.canvas.CanvasActivity
import com.jweihao.jdemo.ui.activity.example.ExampleActivity
import com.jweihao.jdemo.ui.activity.md.MaterialDesignActivity
import com.jweihao.jdemo.ui.activity.property.ViewStubActivity
import com.wh.customcontrol.R
import kotlinx.android.synthetic.main.activity_hero_main.*

class HeroMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_main)
//        Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show()
        button_hero3.setOnClickListener { startActivity(Intent(this, CustomActivity::class.java)) }
        button_hero6.setOnClickListener { startActivity(Intent(this, CanvasActivity::class.java)) }
        button_hero7.setOnClickListener { startActivity(Intent(this, AnimationActivity::class.java)) }
        button_hero10.setOnClickListener { startActivity(Intent(this, ViewStubActivity::class.java)) }
        button_hero12.setOnClickListener { startActivity(Intent(this, MaterialDesignActivity::class.java)) }
        button_hero13.setOnClickListener { startActivity(Intent(this, Hero13Activity::class.java)) }

    }

}


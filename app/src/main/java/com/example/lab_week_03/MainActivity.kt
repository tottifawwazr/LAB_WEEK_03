package com.example.lab_week_03

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ListFragment.CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // optional: insets
        val root = findViewById<View?>(R.id.main) ?: window.decorView
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
    }

    // dipanggil saat item list diklik
    override fun onSelected(id: Int) {
        val detail = supportFragmentManager
            .findFragmentById(R.id.fragment_detail) as? DetailFragment
        detail?.setCoffeeData(id)
    }
}

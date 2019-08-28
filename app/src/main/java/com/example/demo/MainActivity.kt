package com.example.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container, MainFragment.newInstance()).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (!onBackPressedDispatcher.hasEnabledCallbacks()) {
            finish()
        }
    }

    override fun finish() {
        Toast.makeText(this, "[Finish]", Toast.LENGTH_SHORT).show()
        super.finish()
    }
}

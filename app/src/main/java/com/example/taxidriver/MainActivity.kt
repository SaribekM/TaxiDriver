package com.example.taxidriver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taxidriver.ui.ListFragment
import com.example.taxidriver.ui.RecyclerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

}
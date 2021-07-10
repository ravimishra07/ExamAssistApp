package com.examassistapp.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examassistapp.R
import com.examassistapp.databinding.ActivityDashboardBinding

//class DashboardActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dashboard2)
//    }
//}
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dashboard)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        context = this
        setContentView(view)
        //  layoutInflater.inflate(R.layout.activity_dashboard,bind)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(3).isEnabled = false
        // binding.bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod)

    }

}
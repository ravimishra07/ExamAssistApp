package com.examassistapp.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.examassistapp.Fragments.NotesFragment
import com.examassistapp.Fragments.PaperFragment
import com.examassistapp.Fragments.SyllabusFragment
import com.examassistapp.R
import com.examassistapp.databinding.ActivityDashboardBinding
import com.examassistapp.databinding.BaseLayoutBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var bindingBase: BaseLayoutBinding

    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        bindingBase = binding.baseLayout
        context = this
        setContentView(view)
//        setSupportActionBar(bindingBase.toolbar)
        bindingBase.bottomNavigationView.background = null
        bindingBase.bottomNavigationView.menu.getItem(3).isEnabled = false
        bindingBase.bottomNavigationView.setOnItemSelectedListener(bottomNavMethod)
        loadFragments(NotesFragment())
    }

    private val bottomNavMethod = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        var fragment: Fragment? = null
        when (menuItem.itemId) {
            R.id.navigation_notes -> fragment = NotesFragment()
            R.id.navigation_paper -> fragment = PaperFragment()
            R.id.navigation_syllabus -> fragment = SyllabusFragment()
        }
        loadFragments(fragment)
    }

    override fun onBackPressed() {
        if (bindingBase.bottomNavigationView!!.getSelectedItemId() == R.id.navigation_notes) {
            super.onBackPressed()
            finish()
        } else {
            bindingBase.bottomNavigationView!!.setSelectedItemId(R.id.navigation_notes)
        }

    }

    private fun loadFragments(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, fragment).commit()
        }
        return true
    }

}
package id.phephen.sehatq_test.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.ActivityLoginBinding
import id.phephen.sehatq_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
        setBottomNavigation()
    }

    private fun initView() {
        bottomNav = binding.bottomNav
        progressBar = binding.progressBar
    }

    private fun setBottomNavigation() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    true
                }
                R.id.menu_feed -> {
                    true
                }
                R.id.menu_cart -> {
                    true
                }
                R.id.menu_profile -> {
                    true
                }
                else -> false
            }
        }
    }
}
package id.phephen.sehatq_test.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.ActivityMainBinding
import id.phephen.sehatq_test.helpers.Constants.Companion.RC_SIGN_IN
import id.phephen.sehatq_test.ui.fragment.cart.CartFragment
import id.phephen.sehatq_test.ui.fragment.feed.FeedFragment
import id.phephen.sehatq_test.ui.fragment.home.HomeFragment
import id.phephen.sehatq_test.ui.fragment.profile.ProfileFragment


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
        initialize()
        setBottomNavigation()

    }

    private fun initView() {
        bottomNav = binding.bottomNav
        progressBar = binding.progressBar
    }

    private fun initialize() {
        val fragment = HomeFragment.newInstance()
        addFragment(fragment)
    }

    private fun setBottomNavigation() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val fragment = HomeFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_feed -> {
                    val fragment = FeedFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_cart -> {
                    val fragment = CartFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_profile -> {
                    val fragment = ProfileFragment.newInstance()
                    addFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}
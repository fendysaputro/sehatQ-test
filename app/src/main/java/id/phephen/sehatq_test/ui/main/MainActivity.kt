package id.phephen.sehatq_test.ui.main

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.ActivityMainBinding
import id.phephen.sehatq_test.local.db.PurchaseDatabase
import id.phephen.sehatq_test.local.db.SearchDatabase
import id.phephen.sehatq_test.repository.HomeRepository
import id.phephen.sehatq_test.repository.SearchRepository
import id.phephen.sehatq_test.ui.fragment.cart.CartFragment
import id.phephen.sehatq_test.ui.fragment.feed.FeedFragment
import id.phephen.sehatq_test.ui.fragment.home.HomeFragment
import id.phephen.sehatq_test.ui.fragment.profile.ProfileFragment
import id.phephen.sehatq_test.ui.fragment.viewmodel.HomeViewModel
import id.phephen.sehatq_test.ui.fragment.viewmodel.HomeViewModelProviderFactory
import id.phephen.sehatq_test.ui.fragment.viewmodel.SearchViewModel
import id.phephen.sehatq_test.ui.fragment.viewmodel.SearchViewModelProviderFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var progressBar: ProgressBar

    lateinit var viewModel: HomeViewModel
    lateinit var searchViewModel: SearchViewModel

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
        val purchaseDatabase = PurchaseDatabase(this)
        val repository = HomeRepository(purchaseDatabase)
        val factory = HomeViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        val searchDatabase = SearchDatabase(this)
        val searchRepository = SearchRepository(searchDatabase)
        val searchFactory = SearchViewModelProviderFactory(searchRepository)
        searchViewModel = ViewModelProvider(this, searchFactory).get(SearchViewModel::class.java)
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
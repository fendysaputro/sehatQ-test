package id.phephen.sehatq_test.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import id.phephen.sehatq_test.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var lytSearch: LinearLayout
    private lateinit var etSearch: EditText
    private lateinit var rvSearchResult: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
    }

    private fun initView() {
        lytSearch = binding.lytSearch
        etSearch = binding.etSearch
        rvSearchResult = binding.rvSearchResult
        progressBar = binding.progressBar
    }
}
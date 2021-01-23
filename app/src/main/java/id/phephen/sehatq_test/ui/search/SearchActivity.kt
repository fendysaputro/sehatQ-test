package id.phephen.sehatq_test.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import id.phephen.sehatq_test.adapter.SearchAdapter
import id.phephen.sehatq_test.databinding.ActivitySearchBinding
import id.phephen.sehatq_test.local.db.SearchDatabase
import id.phephen.sehatq_test.repository.SearchRepository
import id.phephen.sehatq_test.ui.fragment.viewmodel.SearchViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var lytSearch: LinearLayout
    private lateinit var etSearch: EditText
    private lateinit var rvSearchResult: RecyclerView
    private lateinit var progressBar: ProgressBar

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
//        initialize()
        initEditText()
    }

    private fun initView() {
        lytSearch = binding.lytSearch
        etSearch = binding.etSearch
        rvSearchResult = binding.rvSearchResult
        progressBar = binding.progressBar
    }

//    private fun initialize() {
//        val db = SearchDatabase
//        val repository = SearchRepository(db)
//        searchViewModel = SearchViewModel(repository)
//    }

    private fun initEditText() {
        etSearch.requestFocus()
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
//                searchViewModel.searchProduct("%${s}%").observe(this, Observer {
//                    searchAdapter.differ.submitList(it)
//                })
            }
        })
    }
}
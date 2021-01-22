package id.phephen.sehatq_test.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.FragmentHomeBinding
import id.phephen.sehatq_test.ui.search.SearchActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var lytSearch: LinearLayout
    private lateinit var progressBar: ProgressBar

    private fun initView() {
        lytSearch = binding.lytSearch
        progressBar = binding.progressBar
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initialize()
    }

    private fun initialize() {
        onLayoutSearchClicked()
    }

    private fun onLayoutSearchClicked() {
        lytSearch.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            startActivityForResult(intent, 88)
        }
    }

    companion object {
        fun newInstance(): HomeFragment{
            val fragment = HomeFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
package id.phephen.sehatq_test.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.adapter.CategoryAdapter
import id.phephen.sehatq_test.adapter.ProductAdapter
import id.phephen.sehatq_test.databinding.FragmentHomeBinding
import id.phephen.sehatq_test.helpers.CheckStatus
import id.phephen.sehatq_test.ui.fragment.viewmodel.HomeViewModel
import id.phephen.sehatq_test.ui.main.MainActivity
import id.phephen.sehatq_test.ui.search.SearchActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var lytSearch: CardView
    private lateinit var progressBar: ProgressBar
    private lateinit var ivSearch: ImageView
    private lateinit var rvCategory: RecyclerView
    private lateinit var rvProduct: RecyclerView
    private lateinit var viewModel: HomeViewModel
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter

    private fun initView() {
        lytSearch = binding.lytSearch
        progressBar = binding.progressBar
        ivSearch = binding.ivSearch
        rvCategory = binding.rvCategory
        rvProduct = binding.rvProduct
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
        setupRecyclerView()
    }

    private fun initialize() {
        onLayoutSearchClicked()
        viewModel = (activity as MainActivity).viewModel
        viewModel.homeData.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is CheckStatus.Success -> {
                    progressBar.visibility = View.GONE
                    response.data?.let { homeResponse ->
                        categoryAdapter.differ.submitList(homeResponse[0].data.category)
                        productAdapter.differ.submitList(homeResponse[0].data.productPromo)
                    }
                }
                is CheckStatus.Error -> {
                    progressBar.visibility = View.GONE
                    response.message?.let { message ->
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    }
                }
                is CheckStatus.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        categoryAdapter = CategoryAdapter()
        productAdapter = ProductAdapter()
        rvCategory.apply {
            adapter = categoryAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        }

        rvProduct.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        productAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("product", it)
            }
        }


    }

    private fun onLayoutSearchClicked() {
        ivSearch.setOnClickListener {
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
package id.phephen.sehatq_test.ui.fragment.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.phephen.sehatq_test.R


class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    companion object {
        fun newInstance(): CartFragment {
            val fragment = CartFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
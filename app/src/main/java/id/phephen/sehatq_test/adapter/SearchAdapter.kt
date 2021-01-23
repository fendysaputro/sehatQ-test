package id.phephen.sehatq_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.local.db.entities.SearchDataItem
import kotlinx.android.synthetic.main.item_search.view.*

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<SearchDataItem>() {
        override fun areItemsTheSame(oldItem: SearchDataItem, newItem: SearchDataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchDataItem, newItem: SearchDataItem): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this)
                .load(item.imageUrl)
                .into(iv_product)
            tv_name.text = item.title
            setOnClickListener {
                onItemClickListener?.let {
                    it(item)
                }
            }
            tv_price.text = item.orice
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((SearchDataItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (SearchDataItem) -> Unit) {
        onItemClickListener = listener
    }
}
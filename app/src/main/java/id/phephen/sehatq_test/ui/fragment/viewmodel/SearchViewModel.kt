package id.phephen.sehatq_test.ui.fragment.viewmodel

import androidx.lifecycle.ViewModel
import id.phephen.sehatq_test.local.db.entities.SearchDataItem
import id.phephen.sehatq_test.repository.SearchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
class SearchViewModel (private val repository: SearchRepository): ViewModel() {

    fun upsert(item: SearchDataItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun searchProduct(query: String) = repository.searchProduct(query)
}
package id.phephen.sehatq_test.ui.fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.phephen.sehatq_test.repository.SearchRepository

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
@Suppress("UNCHECKED_CAST")
class SearchViewModelProviderFactory (private val repository: SearchRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
    }
}
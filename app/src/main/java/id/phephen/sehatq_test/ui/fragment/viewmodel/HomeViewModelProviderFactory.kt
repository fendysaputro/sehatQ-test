package id.phephen.sehatq_test.ui.fragment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.phephen.sehatq_test.repository.HomeRepository

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
class HomeViewModelProviderFactory (private val homeRepository: HomeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(homeRepository) as T
    }

}
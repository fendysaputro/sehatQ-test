package id.phephen.sehatq_test.ui.fragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.phephen.sehatq_test.helpers.CheckStatus
import id.phephen.sehatq_test.local.db.entities.PurchaseDataItem
import id.phephen.sehatq_test.repository.HomeRepository
import id.phephen.sehatq_test.response.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by phephen on 23,January,2021
 * https://github.com/fendysaputro
 */
class HomeViewModel (val homeRepository: HomeRepository) : ViewModel() {

    val homeData: MutableLiveData<CheckStatus<BaseResponse>> = MutableLiveData()

    init {
        getDataHome()
    }

    fun upsert(item: PurchaseDataItem) = CoroutineScope(Dispatchers.Main).launch {
        homeRepository.upsert(item)
    }

    fun getAllPurchaseItem() = homeRepository.getAllPurchased()

    fun getDataHome() = viewModelScope.launch {
        homeData.postValue(CheckStatus.Loading())
        val response = homeRepository.getHomeData()
        homeData.postValue(handleDataHomeResponse(response))
    }

    private fun handleDataHomeResponse(response: Response<BaseResponse>) : CheckStatus<BaseResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return CheckStatus.Success(it)
            }
        }
        return CheckStatus.Error(response.message())
    }

}
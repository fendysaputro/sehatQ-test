package id.phephen.sehatq_test.repository

import id.phephen.sehatq_test.api.RetrofitClient
import id.phephen.sehatq_test.local.db.PurchaseDatabase
import id.phephen.sehatq_test.local.db.entities.PurchaseDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
class HomeRepository(
    private val db: PurchaseDatabase
) {
    suspend fun getHomeData() = RetrofitClient.api.getDataHome()
    suspend fun upsert(item: PurchaseDataItem) = db.getPurchaseDao().upsert(item)
    fun getAllPurchased() = db.getPurchaseDao().getPurchasedItems()
}
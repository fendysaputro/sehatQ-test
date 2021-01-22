package id.phephen.sehatq_test.repository

import id.phephen.sehatq_test.local.db.SearchDatabase
import id.phephen.sehatq_test.local.db.entities.SearchDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
class SearchRepository(
    private val db: SearchDatabase
) {
    suspend fun upsert(item: SearchDataItem) = db.getSearchDao().upsert(item)
    fun searchProduct(query: String) = db.getSearchDao().searchProduct(query)
}
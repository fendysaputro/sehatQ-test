package id.phephen.sehatq_test.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.phephen.sehatq_test.local.db.entities.SearchDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
@Dao
interface SearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(searchDataItem: SearchDataItem)

    @Delete
    suspend fun delete(movieItem: SearchDataItem)

    @Query("SELECT * FROM search_data_item WHERE item_title LIKE :query")
    fun searchProduct(query: String): LiveData<List<SearchDataItem>>
}
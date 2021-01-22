package id.phephen.sehatq_test.local

import androidx.lifecycle.LiveData
import androidx.room.*
import id.phephen.sehatq_test.local.db.entities.PurchaseDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
@Dao
interface PurchaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(purchaseDataItem: PurchaseDataItem)

    @Query("SELECT * FROM purchase_data_item")
    fun getPurchasedItems(): LiveData<List<PurchaseDataItem>>
}
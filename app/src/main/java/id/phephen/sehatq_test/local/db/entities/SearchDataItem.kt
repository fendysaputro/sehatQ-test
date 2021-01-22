package id.phephen.sehatq_test.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
@Entity(tableName = "search_data_item")
data class SearchDataItem(
    @ColumnInfo(name = "item_title")
    var title: String,
    @ColumnInfo(name = "item_description")
    var description: String,
    @ColumnInfo(name = "item_image")
    var imageUrl: String,
    @ColumnInfo(name = "price")
    var orice: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
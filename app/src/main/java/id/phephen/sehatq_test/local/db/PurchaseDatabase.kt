package id.phephen.sehatq_test.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.phephen.sehatq_test.local.PurchaseDao
import id.phephen.sehatq_test.local.db.entities.PurchaseDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
@Database(
    entities = [PurchaseDataItem::class],
    version = 1
)
abstract class PurchaseDatabase : RoomDatabase() {
    abstract fun getPurchaseDao(): PurchaseDao

    companion object {
        @Volatile
        private var instance: PurchaseDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            PurchaseDatabase::class.java,
            "Purchase.db"
        ).build()

    }
}
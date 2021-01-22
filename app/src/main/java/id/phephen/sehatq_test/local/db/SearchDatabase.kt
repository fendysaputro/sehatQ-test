package id.phephen.sehatq_test.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.phephen.sehatq_test.local.SearchDao
import id.phephen.sehatq_test.local.db.entities.SearchDataItem

/**
 * Created by phephen on 22,January,2021
 * https://github.com/fendysaputro
 */
@Database(
    entities = [SearchDataItem::class],
    version = 1
)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun getSearchDao(): SearchDao

    companion object {
        @Volatile
        private var instance: SearchDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            SearchDatabase::class.java,
            "SearchDB.db"
        ).build()

    }
}
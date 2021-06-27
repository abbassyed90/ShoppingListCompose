package com.abbas.compose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "grocery-list-compose.db"

@Database(
    entities = [DatabaseList::class, DatabaseItem::class, DatabaseListItem::class, DatabaseCategory::class, DatabaseSortOrder::class],
    version = 1
)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun listDao(): ListDao

    abstract fun listItemDao(): ListItemDao

    abstract fun itemDao(): ItemDao

    abstract fun categoryDao(): CategoryDao

    abstract fun sortOrderDao(): SortOrderDao

    companion object {

        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getInstance(context: Context): ItemDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: providesDatabase(context).also { INSTANCE = it }
            }

        private fun providesDatabase(applicationContext: Context?): ItemDatabase {
            return Room.databaseBuilder(
                applicationContext!!,
                ItemDatabase::class.java,
                DATABASE_NAME
            )
                .build()
        }

    }

}
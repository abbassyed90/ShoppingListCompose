package com.abbas.compose.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T): List<Long>

}

@Dao
interface ListDao : BaseDao<DatabaseList> {

    @Query("DELETE FROM DatabaseList WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM DatabaseList")
    fun getAll(): Flow<List<DatabaseList>>

    @Query("SELECT * FROM DatabaseList")
    suspend fun getAllLists(): List<DatabaseList>

}

@Dao
interface ListItemDao : BaseDao<DatabaseListItem> {

    @Query("SELECT * FROM DatabaseListItem WHERE listId = :listId")
    fun loadAllListItemStream(listId: Int): Flow<List<DatabaseListItem>>

    @Query("SELECT EXISTS(SELECT * FROM DatabaseListItem WHERE listId = :listId AND itemId = :itemId)")
    suspend fun doesListItemExist(listId: Int, itemId: Int): Boolean

    @Query("UPDATE DatabaseListItem SET checked = :checked WHERE listId = :listId AND itemId = :itemId")
    suspend fun updateListItemChecked(listId: Int, itemId: Int, checked: Boolean)

    @Query("UPDATE DatabaseListItem SET quantity = :quantity WHERE listId = :listId AND itemId = :itemId")
    suspend fun updateListItemAmount(listId: Int, itemId: Int, quantity: Int)

    @Query("DELETE FROM DatabaseListItem WHERE listId = :listId")
    suspend fun deleteAllListItems(listId: Int)

    @Query("DELETE FROM DatabaseListItem WHERE listId = :listId AND itemId = :itemId")
    suspend fun delete(listId: Int, itemId: Int)

    @Query("SELECT COUNT(*) FROM DatabaseListItem WHERE listId =:listId AND checked = 1")
    fun countCompletedItems(listId: Int): Int

    @Query("SELECT COUNT(*) FROM DatabaseListItem WHERE listId =:listId")
    fun countTotalItems(listId: Int): Int

    @Query("UPDATE DatabaseListItem SET inStock = :inStock WHERE listId = :listId AND itemId = :itemId")
    fun updateInStock(listId: Int, itemId: Int, inStock: Boolean)

}

@Dao
interface ItemDao : BaseDao<DatabaseItem> {

    @Query("SELECT * FROM DatabaseItem")
    fun getAllItemStream(): Flow<List<DatabaseItem>>

    @Query("SELECT * FROM DatabaseItem WHERE id IN(:ids)")
    fun get(ids: List<Int>): Flow<List<DatabaseItem>>

    @Query("SELECT * FROM DatabaseItem WHERE id IN(:ids)")
    fun getItems(ids: List<Int>): List<DatabaseItem>

    @Query("SELECT * FROM DatabaseItem WHERE id = :ids")
    fun get(ids: Int): DatabaseItem?

    @Query("DELETE FROM DatabaseItem WHERE id = :id")
    suspend fun delete(id: Int)

}

@Dao
interface CategoryDao : BaseDao<DatabaseCategory> {

    @Query("SELECT * FROM DatabaseCategory")
    fun getAllItemStream(): Flow<List<DatabaseCategory>>

    @Query("SELECT * FROM DatabaseCategory")
    suspend fun getAllCategories(): List<DatabaseCategory>

    @Query("DELETE FROM DatabaseCategory WHERE id =:id")
    suspend fun delete(id: Int)

    @Query("SELECT * FROM DatabaseCategory WHERE id =:id")
    suspend fun get(id: Int): DatabaseCategory?

}

@Dao
interface SortOrderDao : BaseDao<DatabaseSortOrder> {

    @Query("SELECT * FROM DatabaseSortOrder WHERE listId = :listId AND categoryId = :categoryId")
    suspend fun get(listId: Int, categoryId: Int): DatabaseSortOrder

    @Query("SELECT * FROM DatabaseSortOrder WHERE listId = :listId")
    fun getAllSortOrderStream(listId: Int): Flow<List<DatabaseSortOrder>>

    @Update
    suspend fun updateSortOrder(sortOrders: List<DatabaseSortOrder>)

}


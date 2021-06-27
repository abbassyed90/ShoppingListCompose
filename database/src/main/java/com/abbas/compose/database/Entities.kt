 package com.abbas.compose.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class DatabaseList(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String)

@Entity(primaryKeys = ["listId", "itemId"],
        foreignKeys = [ForeignKey(entity = DatabaseItem::class,
                parentColumns = ["id"],
                childColumns = ["itemId"],
                onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = DatabaseList::class,
                    parentColumns = ["id"],
                    childColumns = ["listId"],
                    onDelete = ForeignKey.CASCADE)]
)
data class DatabaseListItem(val listId: Int, val itemId: Int, val quantity: Int = 1, val checked: Boolean = false, val inStock: Boolean = true)

@Entity
data class DatabaseItem(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String, val categoryId: Int)

@Entity
data class DatabaseCategory(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String, val color: String = "")

@Entity(foreignKeys = [
    ForeignKey(entity = DatabaseCategory::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE)
])
data class DatabaseSortOrder(@PrimaryKey(autoGenerate = true) val id: Int = 0, val listId: Int, val categoryId: Int, val order: Int = Int.MAX_VALUE)
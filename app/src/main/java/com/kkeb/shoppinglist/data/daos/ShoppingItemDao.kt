package com.kkeb.shoppinglist.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kkeb.shoppinglist.data.entities.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingItemDao {
    @Insert
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Update
    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getShoppingItems(): Flow<List<ShoppingItem>>
}
package com.kkeb.shoppinglist.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kkeb.shoppinglist.data.entities.ShoppingEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingEventDao {
    @Insert
    suspend fun insertShoppingEvent(shoppingEvent: ShoppingEvent)

    @Update
    suspend fun updateShoppingEvent(shoppingEvent: ShoppingEvent)

    @Delete
    suspend fun deleteShoppingEvent(shoppingEvent: ShoppingEvent)

    @Query("SELECT * FROM shopping_events")
    fun getAllShoppingEvents(): Flow<List<ShoppingEvent>>
}
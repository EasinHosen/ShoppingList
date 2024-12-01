package com.kkeb.shoppinglist.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kkeb.shoppinglist.data.entities.ShoppingEvent
import com.kkeb.shoppinglist.data.entities.ShoppingItem
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

    @Query(
        "select se.id, se.name, se.initial_budget, se.event_date, se.completed, " +
                "(select sum(i.price * i.quantity )from shopping_items i where i.event_id = se.id) as total_cost," +
                "i.id, i.event_id, i.item_name, i.price, i.quantity " +
                "from shopping_events se left join shopping_items i on se.id = i.event_id " +
                "where se.id = :id")
    fun getShoppingEventWithItems(id: Long): Flow<Map<ShoppingEvent, List<ShoppingItem>>>
}
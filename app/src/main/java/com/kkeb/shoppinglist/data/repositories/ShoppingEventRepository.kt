package com.kkeb.shoppinglist.data.repositories

import com.kkeb.shoppinglist.data.daos.ShoppingEventDao
import com.kkeb.shoppinglist.data.entities.ShoppingEvent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ShoppingEventRepository {
    suspend fun insertShoppingEvent(shoppingEvent: ShoppingEvent)

    suspend fun updateShoppingEvent(shoppingEvent: ShoppingEvent)

    suspend fun deleteShoppingEvent(shoppingEvent: ShoppingEvent)

    fun getAllShoppingEvents(): Flow<List<ShoppingEvent>>
}


class ShoppingEventRepositoryImpl @Inject constructor(
    private val shoppingEventDao: ShoppingEventDao
) : ShoppingEventRepository {
    override suspend fun insertShoppingEvent(shoppingEvent: ShoppingEvent) =
        shoppingEventDao.insertShoppingEvent(shoppingEvent)


    override suspend fun updateShoppingEvent(shoppingEvent: ShoppingEvent) =
        shoppingEventDao.updateShoppingEvent(shoppingEvent)


    override suspend fun deleteShoppingEvent(shoppingEvent: ShoppingEvent) =
        shoppingEventDao.deleteShoppingEvent(shoppingEvent)


    override fun getAllShoppingEvents(): Flow<List<ShoppingEvent>> =
         shoppingEventDao.getAllShoppingEvents()

}
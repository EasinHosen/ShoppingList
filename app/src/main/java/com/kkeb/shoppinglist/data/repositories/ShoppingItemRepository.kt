package com.kkeb.shoppinglist.data.repositories

import com.kkeb.shoppinglist.data.daos.ShoppingItemDao
import com.kkeb.shoppinglist.data.entities.ShoppingItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ShoppingItemRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun getShoppingItems(): Flow<List<ShoppingItem>>
}

class ShoppingItemRepositoryImpl @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao
) : ShoppingItemRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) =
        shoppingItemDao.insertShoppingItem(shoppingItem)

    override suspend fun updateShoppingItem(shoppingItem: ShoppingItem) =
        shoppingItemDao.updateShoppingItem(shoppingItem)

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) =
        shoppingItemDao.deleteShoppingItem(shoppingItem)

    override fun getShoppingItems(): Flow<List<ShoppingItem>> = shoppingItemDao.getShoppingItems()
}
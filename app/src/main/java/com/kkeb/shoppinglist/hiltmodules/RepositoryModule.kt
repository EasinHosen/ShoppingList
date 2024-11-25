package com.kkeb.shoppinglist.hiltmodules

import com.kkeb.shoppinglist.data.repositories.ShoppingEventRepository
import com.kkeb.shoppinglist.data.repositories.ShoppingEventRepositoryImpl
import com.kkeb.shoppinglist.data.repositories.ShoppingItemRepository
import com.kkeb.shoppinglist.data.repositories.ShoppingItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindShoppingEventRepository(
        impl: ShoppingEventRepositoryImpl
    ): ShoppingEventRepository

    @Binds
    abstract fun bindShoppingItemRepository(
        impl: ShoppingItemRepositoryImpl
    ): ShoppingItemRepository
}
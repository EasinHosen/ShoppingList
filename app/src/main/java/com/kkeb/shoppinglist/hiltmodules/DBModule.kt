package com.kkeb.shoppinglist.hiltmodules

import android.content.Context
import com.kkeb.shoppinglist.data.daos.ShoppingEventDao
import com.kkeb.shoppinglist.data.daos.ShoppingItemDao
import com.kkeb.shoppinglist.data.db.ShoppingDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    fun provideShoppingDB(@ApplicationContext context: Context): ShoppingEventDao {
        return ShoppingDB.getDBInstance(context).shoppingEventDao()
    }

    @Provides
    fun provideShoppingItemDao(@ApplicationContext context: Context): ShoppingItemDao {
        return ShoppingDB.getDBInstance(context).shoppingItemDao()
    }
}
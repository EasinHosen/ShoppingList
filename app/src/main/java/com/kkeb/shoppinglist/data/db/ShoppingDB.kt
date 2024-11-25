package com.kkeb.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kkeb.shoppinglist.data.daos.ShoppingEventDao
import com.kkeb.shoppinglist.data.daos.ShoppingItemDao

@Database(entities = [ShoppingEventDao::class, ShoppingItemDao::class], version = 1)
abstract class ShoppingDB : RoomDatabase() {
    abstract fun shoppingEventDao(): ShoppingEventDao
    abstract fun shoppingItemDao(): ShoppingItemDao

    companion object {
        const val DATABASE_NAME = "shopping_db"

        @Volatile
        private var Instance: ShoppingDB? = null

        fun getDBInstance(context: Context): ShoppingDB {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    ShoppingDB::class.java,
                    DATABASE_NAME
                ).build().also {
                    Instance = it
                }
            }
        }
    }
}
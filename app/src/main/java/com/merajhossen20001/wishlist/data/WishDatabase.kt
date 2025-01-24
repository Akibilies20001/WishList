package com.merajhossen20001.wishlist.data

import androidx.room.Database
import androidx.room.RoomDatabase

//database tables version and Dao aka db actions for that database

@Database(
    entities = [Wish::class],
    version = 1,
    exportSchema = false
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}
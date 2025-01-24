package com.merajhossen20001.wishlist

import android.content.Context
import androidx.room.Room
import com.merajhossen20001.wishlist.data.WishDatabase
import com.merajhossen20001.wishlist.data.WishRepository

//Graph is a simpleton object where it is used to create a single database for the app
// and provide db functions only when it is required using lazy function

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context = context,
            WishDatabase::class.java,
            name = "wishlist.db"
        ).build()
    }

}
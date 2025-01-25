package com.merajhossen20001.wishlist

import android.app.Application


// invokes the graph provide methode to create database for the app
class WishListApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}
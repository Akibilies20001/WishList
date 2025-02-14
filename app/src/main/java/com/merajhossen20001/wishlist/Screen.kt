package com.merajhossen20001.wishlist


// default routes to different screens
sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AddScreen: Screen("add_screen")
}
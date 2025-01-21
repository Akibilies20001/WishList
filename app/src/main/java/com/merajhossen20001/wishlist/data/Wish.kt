package com.merajhossen20001.wishlist.data

data class Wish(
    val serialNo: Long  = 0L,
    val title : String = "",
    val description : String = ""
)


val dummyData = listOf(

        Wish(serialNo = 1L, title = "Learn Kotlin", description = "Complete the Kotlin basics course."),
        Wish(serialNo = 2L, title = "Travel", description = "Visit the mountains for a weekend getaway."),
        Wish(serialNo = 3L, title = "Read a Book", description = "Finish reading 'Atomic Habits'."),
        Wish(serialNo = 4L, title = "Workout", description = "Start a new fitness routine and stick to it."),
        Wish(serialNo = 5L, title = "Learn Android", description = "Explore Jetpack Compose and build an app.")

)
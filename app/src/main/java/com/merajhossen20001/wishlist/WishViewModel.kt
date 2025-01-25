package com.merajhossen20001.wishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merajhossen20001.wishlist.Graph.wishRepository
import com.merajhossen20001.wishlist.data.Wish
import com.merajhossen20001.wishlist.data.WishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


// the viewmodel that is being passed to different screens to give access to logics to be used by the UIs

class WishViewModel (wishRepository: WishRepository = Graph.wishRepository): ViewModel(){
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleChanged(newTitle: String){
        wishTitleState = newTitle
    }

    fun onWishDescriptionChanged(newDescription: String){
        wishDescriptionState = newDescription
    }




     lateinit var getAllWishes : Flow<List<Wish>>

     init {
         viewModelScope.launch {
             getAllWishes = wishRepository.getWishes()
         }
     }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }

    fun getWishByID(id: Long): Flow<Wish> {
        return wishRepository.getWishById(id)
    }

    fun updateWish(wish: Wish){
        viewModelScope.launch (Dispatchers.IO){
            wishRepository.updateWish(wish)
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteWish(wish)
        }
    }

}
package com.merajhossen20001.wishlist

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.merajhossen20001.wishlist.data.Wish
import com.merajhossen20001.wishlist.data.dummyData

@Composable
fun HomeView(viewModel:WishViewModel, navController:NavHostController){
    val context = LocalContext.current
    Scaffold (
        topBar = { AppBarView(title = "Wish List",
            { Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()})},
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),

                contentColor = Color.White,
                backgroundColor = Color.Cyan,
                onClick = {navController.navigate(Screen.AddScreen.route)}
            ) { Icon(Icons.Default.Add, contentDescription = null) }
        }
    ){
        LazyColumn (Modifier.fillMaxSize().padding(it)){
            items(dummyData){
                wish: Wish ->
                WishItem(wish, {})
            }


        }
    }
}
@Composable
fun WishItem(wish: Wish, onclick : () -> Unit){
    Card (modifier = Modifier.fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable { onclick ()},
        elevation = 10.dp,
        backgroundColor = Color.White
    ){
        Column(Modifier.padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }

    }

}
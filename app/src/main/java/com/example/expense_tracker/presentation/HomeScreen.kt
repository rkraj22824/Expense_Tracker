package com.example.expense_tracker.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expense_tracker.navigation.Screen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {
   Scaffold (
       floatingActionButton = {
           FloatingActionButton(
               onClick = {
                   navController.navigate(Screen.AddTransactionScreen.route)
               },
               ) {
               Icon(
                   imageVector = Icons.Default.Add,
                   contentDescription = "To Add Note"
               )
           }
       },
       bottomBar = {
           BottomAppBar(

           ) {
               Row(
                   modifier = Modifier.fillMaxWidth()
                       ,
                   horizontalArrangement = Arrangement.SpaceAround
               ){
                   Icon(imageVector = Icons.Default.Home,
                       contentDescription = "Home Screen",
                       modifier = Modifier.clickable{
                           navController.navigate(Screen.HomeScreen.route)
                       }
                   )
                   Icon(imageVector = Icons.Default.Dashboard,
                       contentDescription = "All transactions",
                       modifier = Modifier.clickable{
                           navController.navigate(Screen.AllTransactionScreen.route)
                       }
                   )
                   Icon(imageVector = Icons.Default.AccountCircle,
                       contentDescription = "Profile",
                       modifier = Modifier.clickable{
                           navController.navigate(Screen.ProfileScreen.route)
                       })
               }
           }
       }
   ) {
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(15.dp)
               .background(Color.White),
           horizontalAlignment = Alignment.CenterHorizontally,
       ) {
           Spacer(modifier = Modifier.height(32.dp))

           Card(
               modifier = Modifier
                   .background(Color.Gray)
                   .padding(10.dp),
               shape = RoundedCornerShape(16.dp),

               ) {
               Column(
                   modifier = Modifier

                       .padding(24.dp),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(
                       text = "Total Balance",
                       color = Color.Black,
                       fontSize = 16.sp,

                       )

                   Text(
                       text = "-$.Total Balance}",
                       color = Color.Cyan

                   )

                   Spacer(modifier = Modifier.height(24.dp))
                   Row(
                       modifier = Modifier
                           .fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween
                   ) {
                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           horizontalArrangement = Arrangement.Center
                       ) {
                           Box(
                               modifier = Modifier
                                   .clip(CircleShape)
                                   .background(Color(0xFFFAD9E6))
                           ) {
                               Icon(
                                   imageVector = Icons.Outlined.ArrowUpward,
                                   contentDescription = "Income",
                                   modifier = Modifier.size(40.dp),
                                   tint = Color.Green
                               )
                           }
                           Spacer(modifier = Modifier.width(8.dp))

                           Column() {
                               Text(
                                   text = "Income",
                                   color = Color.Green,
                                   fontSize = 16.sp,
                               )
                               Text(
                                   text = "-$.Income}",
                                   color = Color.Green

                               )

                           }
                       }
                       Row(
                           verticalAlignment = Alignment.CenterVertically,
                           horizontalArrangement = Arrangement.Center
                       ) {
                           Box(
                               modifier = Modifier
                                   .clip(CircleShape)
                                   .background(Color(0xFFFAD9E6))
                           ) {
                               Icon(
                                   imageVector = Icons.Outlined.ArrowUpward,
                                   contentDescription = "Expense",
                                   modifier = Modifier.size(40.dp),
                                   tint = Color.Red
                               )
                           }
                           Spacer(modifier = Modifier.width(8.dp))

                           Column() {
                               Text(
                                   text = "Expense",
                                   color = Color.Red,
                                   fontSize = 16.sp,
                               )
                               Text(
                                   text = "-$.Expense}",
                                   color = Color.Red

                               )

                           }
                       }
                   }
               }
           }


           Spacer(modifier = Modifier.height(14.dp))
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(8.dp, 16.dp),
           ) {
               Text(text = "Recent Transactions..")
           }

       }

   }
}

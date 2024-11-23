package com.kkeb.shoppinglist.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kkeb.shoppinglist.routes.AddEventRoute
import com.kkeb.shoppinglist.routes.EventDetailRoute
import com.kkeb.shoppinglist.routes.HomeRoute
import com.kkeb.shoppinglist.ui.screens.addevent.AddEventScreen
import com.kkeb.shoppinglist.ui.screens.eventdetails.EventDetailsScreen
import com.kkeb.shoppinglist.ui.screens.home.HomeScreen
import com.kkeb.shoppinglist.ui.theme.ShoppingListTheme

@Composable
fun ShoppingListApp(modifier: Modifier = Modifier) {
    ShoppingListTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            composable<HomeRoute> {
                HomeScreen(
                    navigateToAddEvent = {
                        navController.navigate(route = AddEventRoute)
                    },
                    modifier = modifier
                )
            }
            composable<AddEventRoute> {
                AddEventScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateUp = { navController.navigateUp() }
                )
            }
            composable<EventDetailRoute> {
                EventDetailsScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateUp = { navController.navigateUp() }
                )
            }

        }
    }
}
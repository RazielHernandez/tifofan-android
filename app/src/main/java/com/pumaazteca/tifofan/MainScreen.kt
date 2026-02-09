package com.pumaazteca.tifofan

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Dashboard : Screen("dashboard", "Dashboard", Icons.Default.Home)
    object MyClub : Screen("my club", "My Club", Icons.Default.Person)
    object Statistics : Screen("statistics", "Statistics", Icons.Default.DateRange)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val items = listOf(
        Screen.Dashboard,
        Screen.MyClub,
        Screen.Statistics,
        Screen.Settings
    )

    Scaffold(
        bottomBar = {
            NavigationBar (
                // Set the background color to the primary color of your theme
                containerColor = MaterialTheme.colorScheme.primary,
                // Set the color for content (icons/text) in unselected items
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                items.forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination?.route == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Avoid multiple copies of same screen
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(screen.icon, contentDescription = screen.title)
                        },
                        label = { Text(screen.title) },
                        colors = NavigationBarItemDefaults.colors(
                            // Color for the selected item (e.g., secondary color)
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            // Color for unselected items (e.g., a variant of onPrimary)
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                            // Indicator color when an item is selected
                            indicatorColor = MaterialTheme.colorScheme.onPrimary // Or any other contrasting color
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Dashboard.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Dashboard.route) { DashboardScreen() }
            composable(Screen.MyClub.route) { MyClubScreen() }
            composable(Screen.Statistics.route) { StatisticsScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}

@Composable
fun DashboardScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Dashboard Screen")
    }
}

@Composable
fun MyClubScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("My Club Screen")
    }
}

@Composable
fun StatisticsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Statistics Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen")
    }
}

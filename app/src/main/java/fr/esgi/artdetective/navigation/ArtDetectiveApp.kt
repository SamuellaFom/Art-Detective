package fr.esgi.artdetective.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.esgi.artdetective.ui.artist.ArtistScreen
import fr.esgi.artdetective.ui.favorites.FavoritesScreen
import fr.esgi.artdetective.ui.gallery.GalleryScreen
import fr.esgi.artdetective.ui.home.HomeScreen
import fr.esgi.artdetective.ui.investigation.InvestigationScreen

@Composable
fun ArtDetectiveApp() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBottomBar = BottomTab.entries.any { it.route == currentRoute }

    val selectTab: (BottomTab) -> Unit = { tab ->
        navController.navigate(tab.route) {
            popUpTo(Destinations.HOME) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    BottomTab.entries.forEach { tab ->
                        NavigationBarItem(
                            selected = currentRoute == tab.route,
                            onClick = { selectTab(tab) },
                            icon = { Icon(tab.icon, contentDescription = null) },
                            label = { Text(tab.label) },
                        )
                    }
                }
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destinations.HOME,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Destinations.HOME) {
                HomeScreen(onStartInvestigation = { navController.navigate(Destinations.investigation(1)) })
            }
            composable(Destinations.GALLERY) {
                GalleryScreen(onOpenInvestigation = { id -> navController.navigate(Destinations.investigation(id)) })
            }
            composable(Destinations.FAVORITES) { FavoritesScreen() }
            composable(
                route = Destinations.INVESTIGATION,
                arguments = listOf(navArgument("artworkId") { type = NavType.IntType }),
            ) { entry ->
                InvestigationScreen(
                    artworkId = entry.arguments?.getInt("artworkId") ?: 0,
                    onSolved = { artistId -> navController.navigate(Destinations.artist(artistId)) },
                    onBack = { navController.popBackStack() },
                )
            }
            composable(
                route = Destinations.ARTIST,
                arguments = listOf(navArgument("artistId") { type = NavType.IntType }),
            ) { entry ->
                ArtistScreen(
                    artistId = entry.arguments?.getInt("artistId") ?: 0,
                    onBack = { navController.popBackStack() },
                )
            }
        }
    }
}
package com.ahorr.chiptest.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahorr.chiptest.presentation.breed.components.BreedScreen
import com.ahorr.chiptest.presentation.breed.BreedViewModel
import com.ahorr.chiptest.presentation.gallery.GalleryViewModel
import com.ahorr.chiptest.presentation.gallery.component.GalleryScreen
import com.ahorr.chiptest.presentation.tutorial.TutorialViewModel
import com.ahorr.chiptest.presentation.tutorial.components.TutorialScreen


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {


        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.TutorialScreen.route
        ) {
            composable(
                route = Route.TutorialScreen.route
            ) {
                val viewModel: TutorialViewModel = hiltViewModel()
                TutorialScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.BreedScreen.route,
            startDestination = Route.NavigatorScreen.route
        ) {
            composable(route = Route.NavigatorScreen.route) {
                val viewModel: BreedViewModel = hiltViewModel()
                BreedScreen(viewModel, navController)
            }
        }


        navigation(
            route = Route.GalleryScreen.route,
            startDestination = Route.BreedScreen.route
        ) {
            composable(
                route = Route.BreedScreen.route, arguments = listOf(
                navArgument("breed") {
                    type = NavType.StringType
                }
            )) { backStackEntry ->
                val breed = backStackEntry.arguments?.getString("breed")
                println(breed + "Gallery lookup")
                val viewModel: GalleryViewModel = hiltViewModel()
                viewModel.populateList(breed.toString())
                GalleryScreen(breed.toString(), viewModel, navController)
            }
        }
    }
}
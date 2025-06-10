package com.ahorr.chiptest.presentation.navgraph

sealed class Route(
    val route: String
) {

    object AppStartNavigation : Route("appStartNavigation")
    object TutorialScreen : Route("tutorial_screen")
    object BreedScreen : Route("breed_screen")
    object GalleryScreen : Route("gallery_screen/{breed}")
    object NavigatorScreen : Route("navigator_screen")
}
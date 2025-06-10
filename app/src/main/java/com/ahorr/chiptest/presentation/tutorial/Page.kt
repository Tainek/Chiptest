package com.ahorr.chiptest.presentation.tutorial

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import com.ahorr.chiptest.R

data class Page(
    @DrawableRes val image: Int,
    val title: Int,
    val description: Int

)

val pages = listOf(
    Page(
        title = R.string.breed_view,
        description = R.string.scroll_through_breeds,
        image = R.drawable.tutorial1
    ),
    Page(
        title = R.string.gallery_view,
        description = R.string.click_gallery,
        image = R.drawable.tutorial2

    )
)

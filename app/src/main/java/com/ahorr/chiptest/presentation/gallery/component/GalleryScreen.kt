package com.ahorr.chiptest.presentation.gallery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.ahorr.chiptest.R
import com.ahorr.chiptest.presentation.gallery.GalleryViewModel
import com.ahorr.chiptest.presentation.navgraph.Route
import com.ahorr.chiptest.util.Constants

@Composable
fun GalleryScreen(breed: String, viewModel: GalleryViewModel, navController: NavHostController) {


    val breedImages by viewModel.breedImages

    if (breedImages.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        LazyColumn(contentPadding = PaddingValues(0.dp, 20.dp, 0.dp, 0.dp)) {
            itemsIndexed(breedImages) { index, breed ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                ) {
                    if (breedImages[index] == Constants.ERROR) {
                        Image(painterResource(R.drawable.ic_network_error), "")
                    } else {
                        AsyncImage(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            model = breedImages[index],
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}
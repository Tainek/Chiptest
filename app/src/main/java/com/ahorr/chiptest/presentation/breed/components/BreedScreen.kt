package com.ahorr.chiptest.presentation.breed.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ahorr.chiptest.presentation.breed.BreedViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.ahorr.chiptest.R
import com.ahorr.chiptest.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BreedScreen(
    viewModel: BreedViewModel,
    navController: NavHostController
) {

    val breeds by viewModel.breeds


    if (breeds.isEmpty() || breeds[0] == "error") {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            if (breeds.isEmpty()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                Image(painterResource(R.drawable.ic_network_error), "")
            }
        }
    } else {

        LazyColumn(modifier = Modifier.padding(PaddingValues(0.dp, 20.dp, 0.dp, 20.dp))) {
            itemsIndexed(breeds) { index, breed ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Route.GalleryScreen.route.replace(
                                    "{breed}",
                                    breed
                                )
                            )
                        }
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),

                    ) {
                    Text(
                        text = " $breed",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}




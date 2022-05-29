package com.segunfrancis.zooanimals.ui.layout.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.segunfrancis.zooanimals.data.BaseZooResponseItem
import com.segunfrancis.zooanimals.util.views.ZooTopAppBar
import com.segunfrancis.zooanimals.ui.layout.details.views.DetailItemView
import com.segunfrancis.zooanimals.ui.layout.details.views.DetailItemViewRange

@Composable
fun AnimalDetailsScreen(item: BaseZooResponseItem, onBackIconClick: (() -> Unit)? = null) {
    Scaffold(topBar = {
        ZooTopAppBar(
            title = item.name,
            showBackIcon = true,
            onBackIconClick = { onBackIconClick?.invoke() })
    }, content = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .verticalScroll(state = rememberScrollState(0), enabled = true)
            ) {
                val context = LocalContext.current
                AsyncImage(
                    model = remember(item.imageLink) {
                        ImageRequest.Builder(context)
                            .data(item.imageLink)
                            .crossfade(true)
                            .build()
                    },
                    contentDescription = "Zoo Animal Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Latin Name", value = item.latinName)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Type", value = item.animalType)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Habitat", value = item.habitat)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Lifespan", value = String.format("%s years", item.lifespan))

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Active time", value = item.activeTime)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Diet", value = item.diet)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemView(label = "Geographical Range", value = item.geoRange)

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemViewRange(
                    label = "Weight",
                    min = item.weightMin,
                    max = item.weightMax,
                    unit = "lbs"
                )

                Spacer(modifier = Modifier.height(16.dp))

                DetailItemViewRange(
                    label = "Length",
                    min = item.lengthMin,
                    max = item.lengthMax,
                    unit = "ft"
                )
            }
        }
    })
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AnimalDetailsScreenPreview() {
    AnimalDetailsScreen(
        item = BaseZooResponseItem(
            "Day",
            "Reptile",
            "Arthropods, seeds, fruit and grains",
            "Southern Mediterranean",
            "Tropical forest",
            0,
            "",
            "Microraptor Zoeptre",
            "30",
            "13",
            "16",
            "Komodo Dragon",
            "12",
            "5"
        )
    )
}

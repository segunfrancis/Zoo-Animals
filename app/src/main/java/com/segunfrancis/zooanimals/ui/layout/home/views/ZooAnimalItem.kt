package com.segunfrancis.zooanimals.ui.layout.home.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.segunfrancis.zooanimals.data.BaseZooResponseItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ZooAnimalItem(item: BaseZooResponseItem, onItemClick: ((BaseZooResponseItem) -> Unit)? = null) {
    Box(modifier = Modifier.padding(8.dp)) {
        Card(
            onClick = { onItemClick?.invoke(item) },
            elevation = 1.dp,
            shape = RoundedCornerShape(CornerSize(4.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                val context = LocalContext.current
                AsyncImage(
                    model = remember(item.imageLink) {
                        ImageRequest.Builder(context)
                            .data(item.imageLink)
                            .crossfade(true)
                            .diskCacheKey(item.imageLink)
                            .memoryCacheKey(item.imageLink)
                            .build()
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(4.dp)
                        .fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.animalType,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(4.dp)
                        .fillMaxWidth(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ZooAnimalItemPreview() {
    ZooAnimalItem(
        item = BaseZooResponseItem(
            "",
            "Reptile",
            "",
            "",
            "",
            0,
            "",
            "",
            "",
            "",
            "",
            "Komodo Dragon",
            "",
            ""
        )
    )
}

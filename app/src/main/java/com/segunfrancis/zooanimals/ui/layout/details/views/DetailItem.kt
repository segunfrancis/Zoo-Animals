package com.segunfrancis.zooanimals.ui.layout.details.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailItemView(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = label, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = value, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
fun DetailItemViewRange(label: String, min: String, max: String, unit: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = label, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 8.dp),
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = String.format("Min: %s %s", min, unit), modifier = Modifier
                    .fillMaxWidth(0.5F)
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp),
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = String.format("Max: %s %s", max, unit), modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 8.dp),
                style = MaterialTheme.typography.h6
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
    }
}

@Composable
@Preview(showBackground = true)
fun DetailItemViewPreview() {
    DetailItemView(label = "Latin Name", value = "Microraptor Zoeptre")
}

@Composable
@Preview(showBackground = true)
fun DetailItemViewRangePreview() {
    DetailItemViewRange(label = "Weight", min = "34", max = "60", unit = "ft")
}

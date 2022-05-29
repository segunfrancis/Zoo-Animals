package com.segunfrancis.zooanimals.util.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.segunfrancis.zooanimals.ui.theme.Purple700

@Composable
fun ProgressIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = Purple700,
            strokeWidth = 4.dp,
            modifier = modifier
                .height(30.dp)
                .width(30.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProgressIndicatorPreview() {
    ProgressIndicator()
}
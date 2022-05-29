package com.segunfrancis.zooanimals.util.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.segunfrancis.zooanimals.util.BASE_URL

@Composable
fun ErrorScreen(errorMessage: String?, onRetryClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Something went wrong 😢",
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(IntrinsicSize.Min)
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
        )

        Spacer(modifier = Modifier.size(16.dp))

        errorMessage?.let {
            Text(
                text = errorMessage,
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
                    .align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = FontFamily.Monospace
                )
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = { onRetryClick.invoke() },
            modifier = Modifier
                .wrapContentHeight()
                .padding(6.dp)
                .wrapContentWidth()
        ) {
            Text(text = "Retry", style = MaterialTheme.typography.button)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(errorMessage = "Could not resolve host name associated with $BASE_URL", onRetryClick = {})
}

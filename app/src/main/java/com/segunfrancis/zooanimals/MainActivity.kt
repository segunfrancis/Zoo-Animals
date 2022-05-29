package com.segunfrancis.zooanimals

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.segunfrancis.zooanimals.data.BaseZooResponseItem
import com.segunfrancis.zooanimals.ui.layout.details.AnimalDetailsScreen
import com.segunfrancis.zooanimals.ui.layout.home.views.ZooHomeScreen
import com.segunfrancis.zooanimals.ui.theme.ZooAnimalsTheme
import com.segunfrancis.zooanimals.util.views.AssetParamType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZooAnimalsTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable(route = "home") {
                        ZooHomeScreen(onItemClick = {
                            val json = Uri.encode(Gson().toJson(it))
                            navController.navigate("details/$json")
                        })
                    }
                    composable(
                        route = "details/{content}",
                        arguments = listOf(navArgument("content") {
                            type = AssetParamType()
                        })
                    ) {
                        it.arguments?.getParcelable<BaseZooResponseItem>("content")
                            ?.let { response ->
                                AnimalDetailsScreen(item = response, onBackIconClick = {
                                    navController.navigateUp()
                                })
                            }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ZooAnimalsTheme {
        ZooHomeScreen()
    }
}

package com.example.homework1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

data class City(val name: String, val description: String, val imageUrl: String)
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun CityListScreenPreview() {
    CityListScreen(rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun CityDetailScreenPreview() {
    CityDetailScreen("Yerevan")
}

@Composable
fun CityExplorerAppPreview() {
    CityExplorerApp()
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "City Explorer")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("cityListScreen")
            }
        ) {
            Text(text = "Explore Cities")
        }
    }
}
@Composable
fun CityListScreen(navController: NavHostController) {
    val cities = listOf(
        City("Yerevan", "capital of Armenia.", "https://images.app.goo.gl/3mVTKZgVvWMCjJ4r9"),
        City("Washington", "capital of the United States.", "https://images.app.goo.gl/LJ8mWcgKy1WPKAkj6"),
        City("Madrid", "capital of Spain.", "https://images.app.goo.gl/M5hVbKaQkiiLatm9A")
    )

    LazyColumn {
        items(cities.size) { index ->
            val city = cities[index]
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("cityDetailScreen/${city.name}")
                    }
            ) {
                Text(text = city.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = city.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}




@Composable
fun CityExplorerApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "welcomeScreen"
    ) {
        composable("welcomeScreen") { WelcomeScreen(navController) }
        composable("cityListScreen") { CityListScreen(navController) }
        composable(
            route = "cityDetailScreen/{cityName}",
            arguments = listOf(navArgument("cityName") { type = NavType.StringType })
        ) { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName")
            cityName?.let {
                CityDetailScreen(it) // Pass the cityName to the composable
            }
        }
    }

}
@Composable
fun CityDetailScreen(cityName: String) {
    Text(
        text = "City: $cityName",
        modifier = Modifier.padding(16.dp)
    )
}

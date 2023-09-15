package emmanuelmuturia.experiment10.navigationlayer

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import emmanuelmuturia.experiment10.uilayer.destinationscreen.DestinationScreen
import emmanuelmuturia.experiment10.uilayer.homescreen.HomeScreen

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {

        composable(route = Routes.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Routes.DestinationScreen.route) {
            DestinationScreen()
        }

    }

}
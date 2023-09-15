package emmanuelmuturia.experiment10.navigationlayer

sealed class Routes(val route: String) {

    data object HomeScreen : Routes(route = "homeScreen")

    data object DestinationScreen : Routes(route = "destinationScreen")

}

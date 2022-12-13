package com.example.passive_cooling

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.passive_cooling.ui.*

/** DEFINING ROUTES (A route is "a string that corresponds to a destination"):
"Enum classes in Kotlin have a name property that returns a string with the property name."
 */
enum class PassiveCoolingScreen(@StringRes val title: Int) {
    MainMenu(title = R.string.screen_title_main_menu),
    UserPreferences(title = R.string.screen_title_my_preferences),
    BuildingPreferences(title = R.string.screen_title_my_building)
}

/** NAVIGATION BAR ALONG THE TOP
 * This has a back button, the title of the page, and a settings button
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassiveCoolingAppbar (
    currentScreen: PassiveCoolingScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    /** THE TOP APP BAR - TITLE AND BACK BUTTON */
    TopAppBar (
        title = { Text(stringResource(currentScreen.title))},
        modifier = modifier,
        navigationIcon = {
            Row (
                horizontalArrangement = Arrangement.End
            ){
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon (
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                }
            }
        }
    )
}

/** ALL NAVIGATION HAPPENS HERE */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PassiveCoolingApp(
    //Do we need the context?
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currRoute = backStackEntry?.destination?.route ?: PassiveCoolingScreen.MainMenu.name
    val screenName = currRoute.split("/")[0] // remove any parameters from the route
    val currentScreen = PassiveCoolingScreen.valueOf(screenName)

    /** ------------------------------- THE APP BAR --------------------------------- */
    Scaffold(
        topBar = {
            PassiveCoolingAppbar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) {

        /** ------------------------------ THE NAVIGATION CONTROLLER -----------------------------*/
        val startScreen = PassiveCoolingScreen.MainMenu.name

        /** ------------------------------- THE NAV HOST --------------------------------- */
        /** This is the main screen holder.
         * We will add all of the routes in a NavHost composable function */
        NavHost(
            navController = navController,
            startDestination = startScreen
        ) {

            /** (mapped to a composable):
             * */
            composable(route = PassiveCoolingScreen.MainMenu.name) {
                ScreenMainMenu(
                    //Buttons
                )
            }
        }
    }
}
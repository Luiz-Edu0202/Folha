package com.folha.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.folha.app.viewmodel.FolhaViewModel
import com.folha.app.ui.screens.*

@Composable
fun FolhaNavHost(
    navController: NavHostController,
    viewModel: FolhaViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ReadingRoute,
        modifier = modifier
    ) {
        composable<ReadingRoute> { ReadingScreen() }
        composable<TrendingRoute> { TrendingScreen(viewModel) }
        composable<SearchRoute> { SearchScreen() }
        composable<GoalsRoute> { GoalsScreen() }
        composable<ClubsRoute> { ClubsScreen(viewModel) }
        composable<AuthRoute> { AuthScreen() }
    }
}
package com.folha.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.folha.app.navigation.*
import com.folha.app.ui.theme.FolhaTheme
import com.folha.app.viewmodel.FolhaViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: FolhaViewModel by viewModels()
        setContent {
            FolhaTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                val navItems = listOf(
                    NavItem("Leitura", Icons.Default.MenuBook, ReadingRoute),
                    NavItem("Trending", Icons.Default.LocalFireDepartment, TrendingRoute),
                    NavItem("Pesquisa", Icons.Default.Search, SearchRoute),
                    NavItem("Metas", Icons.Default.Flag, GoalsRoute),
                    NavItem("Clubes", Icons.Default.Group, ClubsRoute),
                    NavItem("Entrar", Icons.Default.Login, AuthRoute)
                )

                Scaffold(
                    bottomBar = {
                        NavigationBar(containerColor = MaterialTheme.colorScheme.surface) {
                            navItems.forEach { item ->
                                val selected = currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = item.title) },
                                    label = { Text(item.title) },
                                    selected = selected,
                                    onClick = {
                                        navController.navigate(item.route) {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    FolhaNavHost(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding) // Passaremos isso no NavHost
                    )
                }
            }
        }
    }
}

data class NavItem(val title: String, val icon: ImageVector, val route: Any)
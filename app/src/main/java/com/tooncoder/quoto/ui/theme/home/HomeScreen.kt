package com.tooncoder.quoto.ui.theme.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberDrawerState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tooncoder.quoto.QuotoApp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    ModalDrawer(
        drawerContent = { SideNavigationBar(navController) },
        drawerState = rememberDrawerState(DrawerValue.Closed),
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Quoto") },
                        navigationIcon = {
                            IconButton(onClick = { /* Open drawer */ }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                            }
                        },
                        actions = {
                            IconButton(onClick = { /* Handle search action */ }) {
                                Icon(Icons.Filled.Search, contentDescription = "Search")
                            }
                            IconButton(onClick = { /* Handle settings action */ }) {
                                Icon(Icons.Filled.Settings, contentDescription = "Settings")
                            }
                        }
                    )
                },
                bottomBar = { BottomNavigationBar(navController) },
                content = { innerPadding ->
                    // Content of the screen
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Home Screen Content")
                    }
                }
            )
        }
    )
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar {
        BottomNavigation {
            BottomNavigationItem(
                selected = false,
                onClick = { /* Handle button click */ },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                label = { Text(text = "Home") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /* Handle button click */ },
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
                label = { Text(text = "Favorites") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { /* Handle button click */ },
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                label = { Text(text = "Profile") }
            )
        }
    }
}

@Composable
fun SideNavigationBar(navController: NavHostController) {
    ModalDrawer(
        drawerState = rememberDrawerState(DrawerValue.Closed),
        drawerContent = {
            Column {
                Text("Text in Drawer")
                Button(onClick = {

                }) {
                    Text("Close Drawer")
                }
            }
        },
        content = {
            Column {
                Text(
                    text = "Quoto", Modifier.padding(
                        8.dp,8.dp,8.dp,8.dp
                    )
                )
                Divider()
                TextButton(onClick = { navController.navigate("home") }) {
                    Text(text = "Home")
                }
                Divider()
                TextButton(onClick = { /* Handle favorites action */ }) {
                    Text(text = "Favorites")
                }
                Divider()
                TextButton(onClick = { /* Handle profile action */ }) {
                    Text(text = "Profile")
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    QuotoApp()
}
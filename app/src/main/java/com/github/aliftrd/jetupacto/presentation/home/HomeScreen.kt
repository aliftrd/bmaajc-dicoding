package com.github.aliftrd.jetupacto.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.aliftrd.jetupacto.R
import com.github.aliftrd.jetupacto.Screen
import com.github.aliftrd.jetupacto.data.movaiList
import com.github.aliftrd.jetupacto.ui.components.BaseScreen
import com.github.aliftrd.jetupacto.ui.components.MovieItem

@Composable
fun HomeScreen(navController: NavController) {
    val context = navController.context

    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val filteredMovaiList = movaiList.filter { movai ->
        movai.title.contains(searchQuery.text, ignoreCase = true)
    }

    BaseScreen(
        title = context.getString(R.string.app_name),
        actions = {
            IconButton(onClick = {
                navController.navigate(Screen.About.route)
            }) {
                Icon(Icons.Default.Person, "About")
            }
        }
    ) {
        Column {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text(text = "Search...") },
                leadingIcon = { Icon(Icons.Default.Search, "Search") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            )
            LazyColumn {
                itemsIndexed(filteredMovaiList) { index, movai ->
                    MovieItem(
                        movai = movai, context = context,
                        onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                key = "movai",
                                value = movai,
                            )
                            navController.navigate(Screen.Detail.route)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
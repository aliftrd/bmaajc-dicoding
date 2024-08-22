package com.github.aliftrd.jetupacto.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.github.aliftrd.jetupacto.R
import com.github.aliftrd.jetupacto.data.Movai
import com.github.aliftrd.jetupacto.ui.components.BaseScreen

@Composable
fun DetailScreen(navController: NavController) {
    val movai = navController.previousBackStackEntry?.savedStateHandle?.get<Movai>("movai")

    BaseScreen(
        title = movai?.title ?: "Detail Movie",
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            item {
                AsyncImage(
                    model = movai?.posterUrl,
                    contentDescription = movai?.title,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
            }
            item {
                Text(
                    text = stringResource(R.string.synopsis),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
            }
            item {
                Text(
                    text = movai?.synopsis ?: "",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController())
}
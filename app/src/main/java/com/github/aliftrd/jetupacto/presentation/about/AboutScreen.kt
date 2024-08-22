package com.github.aliftrd.jetupacto.presentation.about

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.github.aliftrd.jetupacto.ui.components.BaseScreen

@Composable
fun AboutScreen(navController: NavController) {
    BaseScreen(
        title = "About Me",
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            item {
                AsyncImage(
                    model = "https://fcqqtwiqiuvkdnbqaait.supabase.co/storage/v1/object/public/innefable/profile/avatar.jpeg",
                    contentDescription = "Github Avatar",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
            }
            item {
                Text(
                    text = "Name: Alif Triadi Agung Wicaksono,\nE-mail: alftri.dev@gmail.com",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
            }
            item {
                Text(
                    text = "Hi!, I am a software engineer with a passion for web development and mobile development. I have experience in building web applications using modern technologies and frameworks. I am always eager to learn new things and improve my skills.",
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
fun AboutScreenPreview() {
    AboutScreen(navController = rememberNavController())
}
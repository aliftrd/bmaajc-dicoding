package com.github.aliftrd.jetupacto.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.github.aliftrd.jetupacto.R
import com.github.aliftrd.jetupacto.data.Movai

@Composable
fun MovieItem(movai: Movai, context: Context, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 8.dp),
        onClick = onClick,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = movai.posterUrl,
                clipToBounds = true,
                contentDescription = context.getString(R.string.movie_poster),
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(2 / 3f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = movai.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = movai.synopsis,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                )
            }
        }
    }
}
package com.example.detailsfeature.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.shared.presentation.ArgsNewsItem

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier, newsItem: ArgsNewsItem,
    onBackClicked: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { onBackClicked() },
                modifier.size(25.dp)
            ) {

            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {},
                    modifier.size(25.dp)
                ) {

                }
                Spacer(modifier.padding(horizontal = 10.dp))
                IconButton(
                    onClick = {},
                    modifier.size(25.dp)
                ) {

                }


            }
        }
        Text(
            text = newsItem.title,
            fontWeight = FontWeight.W600,
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 20.dp)
        )

        Spacer(modifier.padding(vertical = 10.dp))

        AsyncImage(
            model = newsItem.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.clip(RoundedCornerShape(5))
        )

        newsItem.description?.let {
            Text(
                text = it,
                fontWeight = FontWeight.W400,
                fontSize = 18.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}
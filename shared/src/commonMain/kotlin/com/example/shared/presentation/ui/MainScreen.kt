package com.example.shared.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W200
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.example.shared.presentation.ArgsNewsItem
import com.example.shared.presentation.viewmodel.MainViewModel


@Composable
fun MainScreen(
    modifier: Modifier = Modifier, viewModel: MainViewModel,
    onClick: (ArgsNewsItem) -> Unit
) {
    Scaffold(
        modifier.fillMaxSize()
    ) { innerPadding ->
        val articles by viewModel.news.collectAsStateWithLifecycle()

        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomTextField(
                    onValueChange = {

                    }, value = "" //todo
                )

                IconButton(
                    onClick = {
                        //TODO
                    }
                ) {

                }
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Last news",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W500
                )
            }
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                items(articles) { article ->
                    NewsCard(
                        newsItem = article,
                        onClick = {
                            onClick(article)
                        })
                }
            }
            Spacer(modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
private fun CustomTextField(onValueChange: () -> Unit, value: String) {
    OutlinedTextField(
        onValueChange = { onValueChange() },
        value = value,
        label = { Text("") },
        shape = RoundedCornerShape(100)
    )

}

@Composable
private fun NewsCard(
    modifier: Modifier = Modifier, newsItem: ArgsNewsItem,
    onClick: () -> Unit
) {
    Column(
        Modifier
            .padding(horizontal = 10.dp)
            .height(250.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(5))
            .clickable {
                onClick()
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = newsItem.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .size(300.dp, 150.dp)
        )
        Spacer(modifier.padding(vertical = 5.dp))
        Text(
            newsItem.title,
            color = Color.Black,
            fontSize = 18.sp,
            maxLines = 3,
            lineHeight = 18.sp,
            fontWeight = W200,
            textAlign = TextAlign.Justify
        )
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Read more",
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
            IconButton(
                onClick = {/*Todo*/ }
            ) {

            }
        }

    }
}
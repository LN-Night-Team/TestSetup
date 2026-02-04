package com.example.test.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W200
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.test.R
import com.example.test.presentation.navigation.NavNewsItem
import com.example.test.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainViewModel,
               onClick: (NavNewsItem) -> Unit) {
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
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        modifier.size(35.dp)
                    )
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
                    text = stringResource(R.string.Last_news),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W500
                )
                Box(
                    modifier
                        .size(35.dp)
                        .background(
                            shape = RoundedCornerShape(100),
                            color = Color.Transparent,
                        )
                        .border(width = 1.dp, color = Color.Black, RoundedCornerShape(100))
                ) {
                    IconButton(
                        onClick = {/*Todo*/ }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                    }
                }
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
fun CustomTextField(onValueChange: () -> Unit, value: String) {
    OutlinedTextField(
        onValueChange = { onValueChange() },
        value = value,
        label = { Text(stringResource(R.string.search)) },
        shape = RoundedCornerShape(100),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) }
    )

}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier, newsItem: NavNewsItem,
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
                text = stringResource(R.string.read_more),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
            IconButton(
                onClick = {/*Todo*/ }
            ) {
                Icon(Icons.Default.Star, contentDescription = null)
            }
        }

    }
}
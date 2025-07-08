package com.example.reviewnest_mvp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.reviewnest_mvp.model.MovieDetailsModel
import com.example.reviewnest_mvp.presenter.MovieDetailsPresenterContract
import com.example.reviewnest_mvp.presenter.MovieDetailsView
import com.example.reviewnest_mvp.ui.theme.White

@Composable
fun MovieDetailsScreen(
    presenter: MovieDetailsPresenterContract,
    movieId: Int,
    onBack: () -> Unit,
) {

    var movie by remember { mutableStateOf<MovieDetailsModel?>(null) }

    val view = remember {
        object : MovieDetailsView {
            override fun showMovieDetails(details: MovieDetailsModel) {
                movie = details
            }
        }
    }

    LaunchedEffect(Unit) {
        presenter.attachView(view)
        presenter.loadMovieDetails(movieId)
    }

    movie?.let { details ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(horizontal = 20.dp, vertical = 50.dp)
        ) {
            // Back Button
            Button(
                onClick = onBack,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Back",
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = details.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 3.sp,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                color = White
            )

            // Backdrop image
            Image(
                painter = rememberAsyncImagePainter(details.landscapeMoviePoster),
                contentDescription = "Backdrop for ${details.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.78f),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Rating: ${"%.1f".format(details.rating)}/10",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 10.dp, top = 40.dp),
                color = White,
            )

            Row {
                Text(text = details.year, fontSize = 16.sp, color = White)
                Text(text = " • ", fontSize = 16.sp, color = White)
                Text(text = details.genres.take(3).joinToString(), fontSize = 16.sp, color = White)
                Text(text = " • ", fontSize = 16.sp, color = White)
                Text(text = details.duration, fontSize = 16.sp, color = White)
            }
        }
    }
}

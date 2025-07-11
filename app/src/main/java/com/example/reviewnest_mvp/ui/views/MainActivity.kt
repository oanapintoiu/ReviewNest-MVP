package com.example.reviewnest_mvp.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.reviewnest_mvp.BuildConfig
import com.example.reviewnest_mvp.network.api.TMDbApiProvider
import com.example.reviewnest_mvp.presenter.MovieDetailsPresenter
import com.example.reviewnest_mvp.presenter.MovieListPresenter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Retrieve the key from BuildConfig
            val apiKey = BuildConfig.TMDB_API_KEY

            // Pass it to the provider
            val provider = remember { TMDbApiProvider(apiKey) }
            var selectedMovieId by remember { mutableStateOf<Int?>(null) }

            if (selectedMovieId == null) {
                val presenter = remember { MovieListPresenter(provider) }
                MovieListScreen(
                    presenter = presenter,
                    onMovieClicked = { movieId -> selectedMovieId = movieId }
                )
            } else {
                selectedMovieId?.let { movieId ->
                    val presenter = remember { MovieDetailsPresenter(provider) }
                    MovieDetailsScreen(
                        presenter = presenter,
                        movieId = movieId,
                        onBack = { selectedMovieId = null }
                    )
                }
            }
        }
    }
}

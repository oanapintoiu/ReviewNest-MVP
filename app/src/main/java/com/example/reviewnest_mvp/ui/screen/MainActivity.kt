package com.example.reviewnest_mvp.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.reviewnest_mvp.BuildConfig
import com.example.reviewnest_mvp.network.api.TMDbApiProvider
import com.example.reviewnest_mvp.presenter.MovieListPresenter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("APIKEY", "TMDB Key at runtime: '${BuildConfig.TMDB_API_KEY}'")

            // Retrieve the key from BuildConfig
            val apiKey = BuildConfig.TMDB_API_KEY

            // Pass it to the provider
            val provider = TMDbApiProvider(apiKey)
            val presenter = remember { MovieListPresenter(provider) }
            MovieListScreen(presenter = presenter)
        }
    }
}

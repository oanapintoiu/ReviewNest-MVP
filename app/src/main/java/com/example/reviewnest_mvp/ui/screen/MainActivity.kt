package com.example.reviewnest_mvp.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.example.reviewnest_mvp.presenter.MoviesPresenter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val presenter = remember { MoviesPresenter() }
            MovieListScreen(presenter = presenter)
        }
    }
}

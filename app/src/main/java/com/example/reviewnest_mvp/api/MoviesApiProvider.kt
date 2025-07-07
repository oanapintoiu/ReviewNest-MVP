package com.example.reviewnest_mvp.api

import com.example.reviewnest_mvp.model.MoviesModel
import com.example.reviewnest_mvp.model.toMoviesModelList

class MoviesApiProvider(private val apiKey: String) {
    suspend fun getMovies(): List<MoviesModel> {
        val response = TMDbApiClient.api.getPopularMovies(apiKey)
        return response.results.toMoviesModelList()
    }
}

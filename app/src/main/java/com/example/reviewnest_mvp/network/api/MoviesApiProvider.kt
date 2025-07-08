package com.example.reviewnest_mvp.network.api

import com.example.reviewnest_mvp.model.MoviesListItemModel
import com.example.reviewnest_mvp.mappers.toMoviesModelList

class MoviesApiProvider(private val apiKey: String) {
    suspend fun getMovies(): List<MoviesListItemModel> {
        val response = TMDbApiClient.api.getPopularMovies(apiKey)
        return response.results.toMoviesModelList()
    }
}

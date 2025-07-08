package com.example.reviewnest_mvp.network.api

import com.example.reviewnest_mvp.model.MovieListItemModel
import com.example.reviewnest_mvp.mappers.toMoviesModelList

class TMBdApiProvider(private val apiKey: String) {
    suspend fun getMovies(): List<MovieListItemModel> {
        val response = TMDbApiClient.api.getPopularMovies(apiKey)
        return response.results.toMoviesModelList()
    }
}

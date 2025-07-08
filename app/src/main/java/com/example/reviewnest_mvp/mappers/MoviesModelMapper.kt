package com.example.reviewnest_mvp.mappers

import com.example.reviewnest_mvp.network.dto.MoviesDTO
import com.example.reviewnest_mvp.model.MoviesListItemModel

fun MoviesDTO.toMoviesModel(): MoviesListItemModel = MoviesListItemModel(
    id = id.toString(),
    title = title,
    posterUrl = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" } ?: "",
    year = releaseDate?.take(4) ?: "",
)

fun List<MoviesDTO>.toMoviesModelList(): List<MoviesListItemModel> = map { it.toMoviesModel() }

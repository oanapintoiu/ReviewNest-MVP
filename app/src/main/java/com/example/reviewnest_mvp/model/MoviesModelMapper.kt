package com.example.reviewnest_mvp.model

fun MoviesDTO.toMoviesModel(): MoviesModel = MoviesModel(
    id = id.toString(),
    title = title,
    posterUrl = backdropPath?.let { "https://image.tmdb.org/t/p/w780$it" } ?: "",
    year = releaseDate?.take(4) ?: ""
)

fun List<MoviesDTO>.toMoviesModelList(): List<MoviesModel> = map { it.toMoviesModel() }

package com.example.reviewnest_mvp.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    val results: List<MoviesDTO>
)

data class MoviesDTO(
    val id: Int,
    val title: String,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("release_date")
    val releaseDate: String?
)

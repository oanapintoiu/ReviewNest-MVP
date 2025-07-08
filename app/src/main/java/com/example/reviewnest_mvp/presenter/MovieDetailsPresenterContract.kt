package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.model.MovieDetailsModel


interface MovieDetailsView{
    fun showMovieDetails(details: MovieDetailsModel)
}

interface MovieDetailsPresenterContract {
    fun attachView(view: MovieDetailsView)
    fun loadMovieDetails(movieId: Int)
}

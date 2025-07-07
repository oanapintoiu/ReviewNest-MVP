package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.model.MoviesModel

//this defines what the UI must show/provide
interface MoviesView {
    fun showMovies(movies: List<MoviesModel>)
}

interface MoviesPresenterContract {
    fun attachView(view: MoviesView)
    fun loadMovies()

}

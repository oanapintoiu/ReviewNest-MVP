package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.model.MoviesListItemModel

//this defines what the UI must show/provide
//Declares functions for attaching the UI and triggering the load of movie data.
interface MoviesView {
    fun showMovies(movies: List<MoviesListItemModel>)
}

interface MoviesPresenterContract {
    fun attachView(view: MoviesView)
    fun loadMovies()

}

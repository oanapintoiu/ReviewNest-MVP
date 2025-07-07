package com.example.reviewnest_mvp.presenter

import com.example.reviewnest_mvp.api.MoviesApiProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//declare a function that the Presenter can call to update the UI with a list of movies
class MoviesPresenter(
    private val provider: MoviesApiProvider
) : MoviesPresenterContract {
    private var view: MoviesView? = null

    override fun attachView(view: MoviesView) {
        this.view = view
    }

    override fun loadMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = provider.getMovies()
            view?.showMovies(movies)
        }
    }
}

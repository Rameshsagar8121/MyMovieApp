package com.example.mydemoproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mydemoproject.Repositories.MainRepo
import com.example.mydemoproject.model.MovieModel

class MainActivityViewModel:ViewModel(){
    private  val mainRepo:MainRepo

    val getMovieList:LiveData<MutableList<MovieModel>>
        get() = mainRepo.getMovieModelLiveData
    init {
        mainRepo=MainRepo()
    }
}
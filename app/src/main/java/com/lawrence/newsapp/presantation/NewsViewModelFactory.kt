package com.lawrence.newsapp.presantation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lawrence.newsapp.domain.usecase.GetNewsHeadlinesUseCase


class NewsViewModelFactory(val app: Application, val
getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsHeadlinesUseCase, app) as T
    }
}
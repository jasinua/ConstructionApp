package com.example.collection.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.collection.data.UserDatabase
import com.example.collection.model.User
import com.example.collection.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class  UserViewModel(

    application: Application,
    private val savedStateHandle: SavedStateHandle
    ): AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>


    private var repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabases(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData.asLiveData()
    }

    fun addUser (user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }


    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }
    private val currentQuery: MutableLiveData<String?> = savedStateHandle.getLiveData("currentQuery", "")

    val results = currentQuery.switchMap { query ->
        if(query!!.isBlank()) {
            repository.readAllData.asLiveData()
        } else {
            repository.searchDatabase(query)
        }
    }

    fun setQuery(query: String?) {
        currentQuery.value = query
    }
}
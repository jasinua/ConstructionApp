package com.example.collection.repository

import androidx.lifecycle.LiveData
import com.example.collection.data.UserDao
import com.example.collection.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val readAllData:Flow<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao. updateUser(user)
    }

    fun searchDatabase (searchQuery:String) : LiveData<List<User>> {
        return userDao.searchDatabase(searchQuery)
    }
}
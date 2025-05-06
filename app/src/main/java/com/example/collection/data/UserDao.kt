package com.example.collection.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.collection.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

   @Query("SELECT * FROM user_table WHERE userName LIKE  :searchQuery OR userLastName LIKE :searchQuery OR userID LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<User>>
}
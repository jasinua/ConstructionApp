package com.example.collection.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.collection.model.Tool


@Dao
interface ToolDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTool(tool: Tool)

    @Update
    suspend fun updateTool(tool: Tool)

    @Query("SELECT * FROM tool_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Tool>>
}
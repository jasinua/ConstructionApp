package com.example.collection.repository

import androidx.lifecycle.LiveData
import com.example.collection.data.ToolDao
import com.example.collection.model.Tool

class ToolRepository(private val toolDao: ToolDao) {

    val readAllData: LiveData<List<Tool>> = toolDao.readAllData()

     suspend fun addTool(tool: Tool) {
        toolDao.addTool(tool)
    }

    suspend fun updateTool(tool: Tool) {
        toolDao.updateTool(tool)
    }
}
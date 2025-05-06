package com.example.collection.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.collection.data.ToolDatabase
import com.example.collection.repository.ToolRepository
import com.example.collection.model.Tool
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  ToolViewModel(application: Application): AndroidViewModel(application) {
     val readAllData: LiveData<List<Tool>>
    private val repository: ToolRepository

    init {
        val toolDao = ToolDatabase.getDatabases(application).toolDao()
        repository = ToolRepository(toolDao)
        readAllData = repository.readAllData
    }

    fun addTool (tool: Tool) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTool(tool)
        }
    }


    fun updateTool(tool: Tool) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTool(tool)
        }
    }
}
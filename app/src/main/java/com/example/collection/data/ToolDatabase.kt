package com.example.collection.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.collection.model.Tool

@Database(entities = [Tool::class], version = 1, exportSchema = false)
abstract class ToolDatabase :RoomDatabase(){

    abstract fun toolDao () : ToolDao

    companion object {

        @Volatile
        private var INSTANCE: ToolDatabase? = null

        fun getDatabases (context: Context): ToolDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return  tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToolDatabase::class.java,
                    "tool_database"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }

}
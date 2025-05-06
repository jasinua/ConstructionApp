package com.example.collection.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tool_table")
data class Tool (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val toolName:String,
    val toolModule:String,
    val toolYear:String,
    val toolDescription:String
        ): Parcelable


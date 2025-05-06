package com.example.collection.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val userName:String,
    val userLastName:String,
    val userBirthday:String,
    val userID:String
): Parcelable
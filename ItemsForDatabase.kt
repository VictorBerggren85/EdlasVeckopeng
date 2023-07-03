package com.example.edlasveckopeng

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) var uid: Int? = 0,
    @ColumnInfo(name = "userName") val userName: String?,
    @ColumnInfo(name = "balance") val balance: Float?,
    @ColumnInfo(name = "pass") val pass: String? = "hemlig",
)

@Entity(tableName = "goals")
data class Goal (
    @PrimaryKey(autoGenerate = true) var gid : Int? = null,
    @ColumnInfo(name = "userId") val userId : String?,
    @ColumnInfo(name = "goalName") val goalName : String?,
    @ColumnInfo(name = "savingsGoal") val savingsGoal : Float? = 0.00f,
    @ColumnInfo(name = "goalImage") val goalImage : Blob? = null,
    @ColumnInfo(name = "goalReached") val goalReached : Boolean? = false
)
package com.example.edlasveckopeng

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) var uid: Int? = 0,
    @ColumnInfo(name = "userName") var userName: String? = "",
    @ColumnInfo(name = "balance") var balance: Float? = 0.00f,
    @ColumnInfo(name = "pass") var pass: String? = "hemlig",
)

@Entity(tableName = "goals")
data class Goal (
    @PrimaryKey(autoGenerate = true) var gid : Int? = 0,
    @ColumnInfo(name = "userId") var userId : Int? = 0,
    @ColumnInfo(name = "goalName") var goalName : String? = "",
    @ColumnInfo(name = "savingsGoal") var savingsGoal : Float? = 0.00f,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var goalImage : ByteArray? = null,
    @ColumnInfo(name = "goalReached") var goalReached : Boolean? = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Goal

        if (goalImage != null) {
            if (other.goalImage == null) return false
            if (!goalImage.contentEquals(other.goalImage)) return false
        } else if (other.goalImage != null) return false

        return true
    }

    override fun hashCode(): Int {
        return goalImage?.contentHashCode() ?: 0
    }
}
package com.example.edlasveckopeng

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, Goal::class],
    version = 1
)

abstract class RoomDatabase : RoomDatabase() {
    abstract  fun getUserDAO(): UserDAO
    abstract  fun getGoalDAO(): GoalDAO
}
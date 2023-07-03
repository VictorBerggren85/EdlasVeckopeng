package com.example.edlasveckopeng

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    // Setters for users
    @Query("UPDATE users SET userName = (:name) WHERE uid IS (:userId)")
    suspend fun setName(userId: Int, name: String)

    @Query("UPDATE users SET balance = (:newBalance) WHERE uid IS (:userId)")
    suspend fun setBalance(userId: Int, newBalance: Float)

    @Query("UPDATE users SET pass = (:passW) WHERE uid IS (:userId)")
    suspend fun setPass(userId: Int, passW: String)

    // Getters for users
    @Query("SELECT count(uid) FROM users")
    suspend fun getNumUsers() : Int

    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IS (:userId)")
    suspend fun getUserById(userId: Int) : User

    @Query("SELECT userName FROM users WHERE uid IS (:userId)")
    suspend fun getUserName(userId: Int) : String

    @Query("SELECT balance FROM users WHERE uid IS (:userId)")
    suspend fun getBalance(userId: Int) : Float

    // Create / Destroy user
    @Insert
    suspend fun insertAll(varargs: User) : User

    @Delete
    suspend fun delete(users: User)
}

@Dao
interface GoalDAO {
    // Setters for goals
    @Query("UPDATE goals SET goalReached = (:reached) WHERE gid IS (:goalId)")
    suspend fun goalReached(goalId: Int, reached: Boolean)

    // Getters for goals
    @Query("SELECT count(gid) FROM goals WHERE userId IS (:userId)")
    suspend fun getNumGoals(userId: Int) : Int

    @Query("SELECT * FROM goals WHERE userId IS (:userId)")
    suspend fun getAll(userId: Int): List<Goal>

    @Query("SELECT * FROM goals WHERE gid IS (:goalId)")
    suspend fun getGoalById(goalId: Int) : Goal

    @Query("SELECT goalReached FROM goals WHERE gid IS (:goalId)")
    suspend fun goalReached(goalId: Int) : Boolean

    // Create / Destroy goal
    @Insert
    suspend fun insertAll(varargs: Goal) : Goal

    @Delete
    suspend fun delete(goals: Goal)
}
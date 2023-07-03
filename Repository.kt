package com.example.edlasveckopeng

import com.example.edlasveckopeng.User
import com.example.edlasveckopeng.Goal
import com.example.edlasveckopeng.UserDAO
import com.example.edlasveckopeng.GoalDAO
import javax.inject.Inject

class Repository @Inject constructor(
    private val userDAO: UserDAO, private val goalDAO: GoalDAO
){
    suspend fun getNumUsers() = userDAO.getNumUsers()
    suspend fun getAllUsers() = userDAO.getAll()
    suspend fun getUserById(userId: Int) = userDAO.getUserById(userId)
    suspend fun insertUser(newUser: User) = userDAO.insertAll(newUser)
    suspend fun deleteUser(userToDelete: User) = userDAO.delete(userToDelete)

    suspend fun getNumUserGoals(uiserId: Int) = goalDAO.getNumGoals(uiserId)
    suspend fun getAllUserGoals(uiserId: Int) = goalDAO.getAll(uiserId)
    suspend fun getGoalById(goalId: Int) = goalDAO.getGoalById(goalId)
    suspend fun insertGoal(newGoal: Goal) = goalDAO.insertAll(newGoal)
    suspend fun deleteGoal(goalToDelete: Goal) = goalDAO.delete(goalToDelete)
}

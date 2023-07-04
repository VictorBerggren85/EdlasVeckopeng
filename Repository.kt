package com.example.edlasveckopeng

import javax.inject.Inject

class Repository @Inject constructor(
    private val userDAO: UserDAO, private val goalDAO: GoalDAO
){
    // Setters
    suspend fun setUserName(userId: Int, newName: String) = userDAO.setUserName(userId, newName)
    suspend fun setBalance(userId: Int, balance: Float) = userDAO.setBalance(userId, balance)
    suspend fun setPass(userId: Int, newPass: String) = userDAO.setPass(userId, newPass)
    // Getters
    suspend fun getNumUsers() = userDAO.getNumUsers()
    suspend fun getUser(userId: Int) = userDAO.getUser(userId)
    suspend fun getUserById(userId: Int) = userDAO.getUserById(userId)
    // Create / Destroy
    suspend fun insertUser(newUser: User) = userDAO.insertAll(newUser)
    suspend fun deleteUser(userToDelete: User) = userDAO.delete(userToDelete)

    // Setters
    suspend fun setUserId(goalId: Int, userId: Int) = goalDAO.setUserId(goalId, userId)
    suspend fun setGoalName(goalId: Int, newName: String) = goalDAO.setGoalName(goalId, newName)
    suspend fun setSavingsGoal(goalId: Int, newSavingsGoal: Float) = goalDAO.setSavingsGoal(goalId, newSavingsGoal)
    suspend fun setGoalImage(goalId: Int, newImage: ByteArray) = goalDAO.setGoalImage(goalId, newImage)
    suspend fun setGoalReached(goalId: Int, success: Boolean) = goalDAO.setGoalReached(goalId, success)
    // Getters
    suspend fun getNumUserGoals(userId: Int) = goalDAO.getNumUserGoals(userId)
    suspend fun getAllUserGoals(userId: Int) = goalDAO.getAll(userId)
    suspend fun getGoalById(goalId: Int) = goalDAO.getGoalById(goalId)
    suspend fun getUserId(goalId: Int) = goalDAO.getUserId(goalId)
    suspend fun getGoalName(goalId: Int) = goalDAO.getGoalName(goalId)
    suspend fun getSavingsGoal(goalId: Int) = goalDAO.getSavingsGoal(goalId)
    suspend fun getGoalImage(goalId: Int) = goalDAO.getGoalImage(goalId)
    // Create / Destroy
    suspend fun insertGoal(newGoal: Goal) = goalDAO.insertAll(newGoal)
    suspend fun deleteGoal(goalToDelete: Goal) = goalDAO.delete(goalToDelete)
}

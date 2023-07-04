package com.example.edlasveckopeng

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object VeckopengModule {
    @Singleton
    @Provides
    fun provideVeckopengDatabase(
        @ApplicationContext app: Context): VeckopengRoomDatabase {
        return Room.databaseBuilder(app,
            VeckopengRoomDatabase::class.java,
            "veckopeng_database"
            ).build()
    }

    @Singleton
    @Provides
    fun provideDatabaseDAOuser(db_goal:VeckopengRoomDatabase): GoalDAO {
        return db_goal.getGoalDAO()
    }

    @Singleton
    @Provides
    fun provideDatabaseDAOgoal(db_user:VeckopengRoomDatabase): UserDAO {
        return db_user.getUserDAO()
    }
}
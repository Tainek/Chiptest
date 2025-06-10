package com.ahorr.chiptest.di

import android.app.Application
import com.ahorr.chiptest.data.manager.LocalUserManagerImpl
import com.ahorr.chiptest.domain.manager.LocalUserManager
import com.ahorr.chiptest.usecase.AppEntryUseCases
import com.ahorr.chiptest.usecase.ReadAppEntry
import com.ahorr.chiptest.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}
package com.itzikpich.giniappssampleapp.di

import com.itzikpich.giniappssampleapp.data.RemoteDataSource
import com.itzikpich.giniappssampleapp.data.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataModule {

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ) : RemoteDataSource

}
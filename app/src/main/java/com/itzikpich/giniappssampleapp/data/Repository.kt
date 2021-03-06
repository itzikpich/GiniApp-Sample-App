package com.itzikpich.giniappssampleapp.data

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) : RemoteDataSource by remoteDataSource
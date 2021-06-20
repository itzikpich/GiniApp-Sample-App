package com.itzikpich.giniappssampleapp.data

import com.itzikpich.giniappssampleapp.models.NumbersResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getNumbersFromNetwork(): Flow<NumbersResponse>

}
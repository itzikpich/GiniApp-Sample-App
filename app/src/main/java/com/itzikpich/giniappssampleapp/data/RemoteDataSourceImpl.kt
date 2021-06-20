package com.itzikpich.giniappssampleapp.data

import com.itzikpich.giniappssampleapp.models.NumbersResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: RetrofitService)
    : RemoteDataSource, RetrofitService by apiService {

    override suspend fun getNumbersFromNetwork(): Flow<NumbersResponse> {
        return flow {
            try {
                val response = getNumbers()
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let { emit(it) }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
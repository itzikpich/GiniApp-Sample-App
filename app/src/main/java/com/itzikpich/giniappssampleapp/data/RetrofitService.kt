package com.itzikpich.giniappssampleapp.data

import com.itzikpich.giniappssampleapp.NUMBERS_URL
import com.itzikpich.giniappssampleapp.models.NumbersResponse
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitService {

    @GET(NUMBERS_URL)
    suspend fun getNumbers() : Response<NumbersResponse>

}
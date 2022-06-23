package com.baktiyar11.bulletinboard.data.api

import com.baktiyar11.bulletinboard.domain.models.category.GetCategoryResponse
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportResponse
import com.baktiyar11.bulletinboard.domain.models.login.ServerResponse
import com.baktiyar11.bulletinboard.domain.models.login.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("users")
    fun createUser(@Body user: User): Call<ServerResponse>

    @GET("classes/Category")
    suspend fun getListOfCategories(): Response<GetCategoryResponse>

    @GET("classes/Transport")
    suspend fun getAllTransport(
        @Query("where") id: String,
    ): Response<TransportResponse>

}
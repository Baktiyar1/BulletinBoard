package com.baktiyar11.bulletinboard.data.api

import com.baktiyar11.bulletinboard.domain.models.category.animals.AnimalsResponse
import com.baktiyar11.bulletinboard.domain.models.category.childrenWord.ChildrenWordResponse
import com.baktiyar11.bulletinboard.domain.models.category.electronics.ElectronicsResponse
import com.baktiyar11.bulletinboard.domain.models.category.giveForFree.GiveForFreeResponse
import com.baktiyar11.bulletinboard.domain.models.category.medicalProducts.MedicalProductsResponse
import com.baktiyar11.bulletinboard.domain.models.category.personalItems.PersonalItemsResponse
import com.baktiyar11.bulletinboard.domain.models.category.realEstate.RealEstateResponse
import com.baktiyar11.bulletinboard.domain.models.category.services.ServicesResponse
import com.baktiyar11.bulletinboard.domain.models.category.sportAndHobbies.SportAndHobbiesResponse
import com.baktiyar11.bulletinboard.domain.models.category.taxi.TaxiResponse
import com.baktiyar11.bulletinboard.domain.models.category.transport.TransportResponse
import com.baktiyar11.bulletinboard.domain.models.category.work.WorkResponse
import com.baktiyar11.bulletinboard.domain.models.login.SaveImageQuestionCloud
import com.baktiyar11.bulletinboard.domain.models.login.ServerResponse
import com.baktiyar11.bulletinboard.domain.models.login.SignInResponse
import com.baktiyar11.bulletinboard.domain.models.login.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @POST("users")
    fun createUser(@Body user: User): Call<ServerResponse>

    @GET("login")
    fun signIn(
        @Query("username") userName: String,
        @Query("password") password: String,
    ): Call<SignInResponse>

    @PUT("users/{id}")
    fun updateUser(
        @Header("X-Parse-Session-Token") sessionToken: String,
        @Path("id") id: String, @Body saveIcon: SaveImageQuestionCloud,
    ): Call<Unit>

//    @GET("search/movie")
//    suspend fun getSearchMovies(
//        @Query("api_key") movie: String? = null,
//        @Query("query") query: String? = null,
//    ) : Response<Transport>

    @GET("classes/Transport")
    suspend fun getAllTransport(@Query("where") id: String): Response<TransportResponse>?

    @GET("classes/RealEstate")
    suspend fun getAllRealEstate(@Query("where") id: String): Response<RealEstateResponse>?

    @GET("classes/Taxi")
    suspend fun getAllTaxi(@Query("where") id: String): Response<TaxiResponse>?

    @GET("classes/Electronics")
    suspend fun getAllElectronics(@Query("where") id: String): Response<ElectronicsResponse>?

    @GET("classes/Services")
    suspend fun getAllServices(@Query("where") id: String): Response<ServicesResponse>?

    @GET("classes/Work")
    suspend fun getAllWork(@Query("where") id: String): Response<WorkResponse>?

    @GET("classes/PersonalItems")
    suspend fun getAllPersonalItems(@Query("where") id: String): Response<PersonalItemsResponse>?

    @GET("classes/Animals")
    suspend fun getAllAnimals(@Query("where") id: String): Response<AnimalsResponse>?

    @GET("classes/SportAndHobbies")
    suspend fun getAllSportAndHobbies(@Query("where") id: String)
            : Response<SportAndHobbiesResponse>?

    @GET("classes/MedicalProducts")
    suspend fun getAllMedicalProducts(@Query("where") id: String)
            : Response<MedicalProductsResponse>?

    @GET("classes/ChildrenWorld")
    suspend fun getAllChildrenWord(@Query("where") id: String): Response<ChildrenWordResponse>?

    @GET("classes/GiveForFree")
    suspend fun getAllGiveForFree(@Query("where") id: String): Response<GiveForFreeResponse>?
}
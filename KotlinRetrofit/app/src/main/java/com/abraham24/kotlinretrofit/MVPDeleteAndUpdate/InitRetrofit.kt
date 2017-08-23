package com.abraham24.kotlinretrofit.MVPDeleteAndUpdate

import com.abraham24.kotlinretrofit.GSONParse.ResponseData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by KOCHOR on 8/22/2017.
 */
class InitRetrofit {

    fun getInitRetrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl("http://192.168.20.159/lumen-api24/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }
}

interface ApiService {

    @GET("input-siswa")
    fun request_insert(
            @Query("nama") name: String,
            @Query("nis") nis: Int,
            @Query("status") status: Int
    ): Call<ResponseInsert>

    @GET("get-siswa")
    fun request_getdata(

    ): Call<ResponseData>

    @FormUrlEncoded
    @POST("update-siswa")
    fun request_update(
            @Field("id") id: String,
            @Field("nama") nama: String,
            @Field("nis") nis: String
    ) : Call<ResponseInsert>

    @FormUrlEncoded
    @POST("delete-siswa")
    fun request_delete(
            @Field("id") id: String
//            @Field("nama") nama: String,
//            @Field("nis") nis: String
    ) : Call<ResponseInsert>
}
package com.abraham24.kotlinretrofit.RecyclerView

import android.util.Log
import com.abraham24.kotlinretrofit.GSONParse.ResponseData
import com.abraham24.kotlinretrofit.MVPDeleteAndUpdate.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by KOCHOR on 8/23/2017.
 */
class PresenterTampilClass {
    var presenter : PresenterTampil? = null

    constructor(presenter: PresenterTampil?) {
        this.presenter = presenter
    }

    fun dataTampil(){

        var api = InitRetrofit().getInitInstance()
        var call = api.request_getdata()

        call.enqueue(object : Callback<ResponseData> {

            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {

            Log.d("Error : ", t.toString())

            }

            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {

                if (response != null) {
                    if (response.isSuccessful){
                        var data = response.body()?.data
                        presenter?.result(data!!)
                    }


                }
            }

        })
    }
}
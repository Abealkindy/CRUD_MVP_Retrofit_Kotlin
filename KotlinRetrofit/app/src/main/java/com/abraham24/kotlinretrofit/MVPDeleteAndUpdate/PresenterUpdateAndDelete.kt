package com.abraham24.kotlinretrofit.MVPDeleteAndUpdate

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by KOCHOR on 8/23/2017.
 */
class PresenterUpdateAndDelete {


    var presenterView: PresenterModel? = null

    constructor(presenterView : PresenterModel?) {

        this.presenterView = presenterView

    }

    fun Input ( nama : String, nis : String, status : Int){

        if (nama.isNotEmpty() && nis.isNotEmpty()) {


            var getInit = InitRetrofit().getInitInstance()

            var request = getInit.request_insert(nama, nis.toInt(), status)

//                var progress = ProgressDialog(applicationContext)
//                progress.setMessage("loading")
//                progress.show()

            request.enqueue(object : Callback<ResponseInsert> {

                override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {

//                        progress.dismiss()
                    Log.d("response ", response?.message())
                    if (response != null) {
                        if (response.isSuccessful && response.body()?.status.equals("true")) {
//                            startActivity(Intent(applicationContext, MainActivity::class.java))
//                            finish()
                            var result = response.body()?.status
                            var messages = response.body()?.msg

                            presenterView?.hasil(result!!, messages!!)

                        }


                    }
                }

                override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

//                        progress.dismiss()
                    Log.d("Error Insert", t.toString())
                }

            })
        }
    }

    fun Update (id : String, name : String, nis : String ){

        var getInit = InitRetrofit().getInitInstance()

        var request = getInit.request_update(id, name, nis)

        request.enqueue(object : Callback<ResponseInsert> {

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {


                Log.d("response ", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {

                        var result = response.body()?.status
                        var messages = response.body()?.msg

                        presenterView?.hasil(result!!, messages!!)

                    }


                }
            }

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

//                        progress.dismiss()
                Log.d("Error Insert", t.toString())
            }

        })
    }

    fun Hapus(id : String) {


        var getInit = InitRetrofit().getInitInstance()

        var request = getInit.request_delete(id)

        request.enqueue(object : Callback<ResponseInsert> {

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {


                Log.d("response ", response?.message())
                if (response != null) {
                    if (response.isSuccessful && response.body()?.status.equals("true")) {

                        var result = response.body()?.status
                        var messages = response.body()?.msg

                        presenterView?.hasil(result!!, messages!!)

                    }


                }
            }

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {

//                        progress.dismiss()
                Log.d("Error Insert", t.toString())
            }

        })
    }
}
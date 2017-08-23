package com.abraham24.kotlinretrofit.RecyclerView

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.abraham24.kotlinretrofit.GSONParse.Datum
import com.abraham24.kotlinretrofit.GSONParse.ResponseData
import com.abraham24.kotlinretrofit.MVPDeleteAndUpdate.InitRetrofit
import com.abraham24.kotlinretrofit.R
import com.abraham24.kotlinretrofit.MVPDeleteAndUpdate.TambahActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), PresenterTampil {


    var presenters : PresenterTampilClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenters = PresenterTampilClass(this)

        presenters!!.dataTampil()
//        dapatData()

        image_plus.setOnClickListener {
            startActivity(Intent(applicationContext, TambahActivity::class.java))
        }

    }

//    private fun dapatData() {
//        var api = InitRetrofit().getInitInstance()
//        var call = api.request_getdata()
//
//        call.enqueue(object : Callback<ResponseData> {
//
//            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {
//                Log.d("response_ok : ", response?.message())
//
//                if (response != null) {
//
//                    if (response.isSuccessful) {
//
//                        var datas = response.body()?.data
//
//
//
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
//
//                Log.d("error_data : ", t.toString())
//            }
//
//        })
//    }
    override fun result(result: List<Datum>) {
        var adapter_recycler = CustomAdapterRecyclerView(this@MainActivity, result)
        var linear = LinearLayoutManager(applicationContext)
        recycler_data.layoutManager = linear
        recycler_data.adapter = adapter_recycler
    }

    override fun Error(error: String) {

    }
}

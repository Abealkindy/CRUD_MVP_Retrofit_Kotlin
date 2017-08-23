package com.abraham24.kotlinretrofit.RecyclerView

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abraham24.kotlinretrofit.GSONParse.Datum
import com.abraham24.kotlinretrofit.R
import com.abraham24.kotlinretrofit.MVPDeleteAndUpdate.UpdateAndDeleteActivity

/**
 * Created by KOCHOR on 8/23/2017.
 */
class CustomAdapterRecyclerView : RecyclerView.Adapter<CustomAdapterRecyclerView.ViewHolder> {
    override fun getItemCount(): Int {

        return data_gson?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        holder?.text_nama?.text = data_gson?.get(position)!!.nama
        holder?.text_nis?.text = data_gson?.get(position)!!.nis.toString()
        holder?.text_move?.setOnClickListener {

            var intents = Intent(act, UpdateAndDeleteActivity::class.java)
            intents
                    .putExtra("id", data_gson?.get(position)!!.id)
                    .putExtra("nama", data_gson?.get(position)!!.nama)
                    .putExtra("nis", data_gson?.get(position)!!.nis)

            act?.startActivity(intents)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(act).inflate(R.layout.wadah_recycler, parent, false)
        return ViewHolder(view)
    }

    var act: Activity? = null
    var data_gson: List<Datum>? = null

    constructor(activity: Activity?, datas: List<Datum>?) {
        act = activity
        data_gson = datas
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var text_nama: TextView? = itemView?.findViewById(R.id.text_nama)
        var text_nis: TextView? = itemView?.findViewById(R.id.text_nis)
        var text_move: TextView? = itemView?.findViewById(R.id.text_move)


    }
}

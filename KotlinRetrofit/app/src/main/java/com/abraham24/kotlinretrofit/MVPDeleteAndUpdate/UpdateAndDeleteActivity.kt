package com.abraham24.kotlinretrofit.MVPDeleteAndUpdate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.abraham24.kotlinretrofit.R
import com.abraham24.kotlinretrofit.RecyclerView.MainActivity
import kotlinx.android.synthetic.main.activity_update_and_delete.*

class UpdateAndDeleteActivity : AppCompatActivity(), PresenterModel {


    var tangkap_nama : String? = null
    var tangkap_id : Long? = null
    var tangkap_nis : Long? = null

    var presenterUpdateandDelete : PresenterUpdateAndDelete? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_and_delete)

         tangkap_nama = intent.getStringExtra("nama")
         tangkap_id = intent.getLongExtra("id", 0)
         tangkap_nis = intent.getLongExtra("nis", 0)

        Log.d("tangkep", tangkap_id.toString())
        presenterUpdateandDelete = PresenterUpdateAndDelete(this)

        edit_text_ubah_nama.setText(tangkap_nama)
        edit_ubah_tambah_nis.setText(tangkap_nis.toString())



        button_ubah.setOnClickListener {
            presenterUpdateandDelete!!.Update(tangkap_id.toString(), edit_text_ubah_nama.text.toString(), edit_ubah_tambah_nis.text.toString())
        }

       button_delete.setOnClickListener {
            presenterUpdateandDelete!!.Hapus(tangkap_id.toString())

       }

    }

    override fun hasil(result: String, message: String) {

        if (result.equals("true")){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT)
        }

    }

    override fun error(errors: String) {

        Log.d("error : ", errors)
    }
}

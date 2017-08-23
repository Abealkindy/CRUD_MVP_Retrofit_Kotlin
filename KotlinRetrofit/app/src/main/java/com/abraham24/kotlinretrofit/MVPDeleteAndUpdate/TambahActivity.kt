package com.abraham24.kotlinretrofit.MVPDeleteAndUpdate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tambah.*
import android.os.Bundle
import android.widget.Toast
import com.abraham24.kotlinretrofit.R
import com.abraham24.kotlinretrofit.RecyclerView.MainActivity

class TambahActivity : AppCompatActivity(), PresenterModel {


    var presenter : PresenterUpdateAndDelete? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        presenter = PresenterUpdateAndDelete(this)

        button_tambah.setOnClickListener {

            var nama = edit_text_tambah_nama.text.toString()
            var nis = edit_text_tambah_nis.text.toString()

            presenter!!.Input(nama, nis, 1)




        }
    }
    override fun hasil(result: String, message: String) {
        if (result.equals("true")){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun error(errors: String) {

        Toast.makeText(applicationContext,errors, Toast.LENGTH_SHORT).show()
    }
}

package com.abraham24.kotlinretrofit.GSONParse

import com.google.gson.annotations.SerializedName


class Datum {

    @SerializedName("id")
    var id: Long? = null
    @SerializedName("nama")
    var nama: String? = null
    @SerializedName("nis")
    var nis: Long? = null
    @SerializedName("status")
    var status: String? = null

}

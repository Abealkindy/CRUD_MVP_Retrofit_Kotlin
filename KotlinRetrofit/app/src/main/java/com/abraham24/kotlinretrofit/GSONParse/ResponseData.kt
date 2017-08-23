package com.abraham24.kotlinretrofit.GSONParse

import com.google.gson.annotations.SerializedName


class ResponseData {

    @SerializedName("data")
    var data: List<Datum>? = null

}

package com.abraham24.kotlinretrofit.RecyclerView

import com.abraham24.kotlinretrofit.GSONParse.Datum

/**
 * Created by KOCHOR on 8/23/2017.
 */
interface PresenterTampil {
    fun result(result: List<Datum>)

    fun Error(error: String)
}
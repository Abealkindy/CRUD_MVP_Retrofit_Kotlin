package com.abraham24.kotlinretrofit.MVPDeleteAndUpdate

/**
 * Created by KOCHOR on 8/23/2017.
 */
interface PresenterModel {

    fun hasil(result : String, message : String)

    fun error(errors : String)
}
package com.oohyugi.gowit.survey_kinerja

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oohyugi.gowit.base.BasePresenter
import com.oohyugi.gowit.model.SurveyMdl
import java.io.InputStream

/**
 * Created by oohyugi on 13/01/19.
 * github: https://github.com/oohyugi
 */
class SurveyKinerjaPresenter(val mView: SurveyKinerjaView) : BasePresenter<SurveyKinerjaView>(mView) {



    fun loadSurveyKinerja(context: Context){

        var listQuestion:MutableList<SurveyMdl> = mutableListOf()
        val type = object : TypeToken<List<SurveyMdl>>(){}.type
        listQuestion = Gson().fromJson(readJSONFromAsset(context),type)
        mView.successLoadQuestion(listQuestion)

    }
    fun readJSONFromAsset(context: Context): String? {
        val json: String?
        try {
            val  inputStream: InputStream = context.assets.open("gowitkinerja.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
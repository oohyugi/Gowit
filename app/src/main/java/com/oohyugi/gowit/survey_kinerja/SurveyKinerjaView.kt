package com.oohyugi.gowit.survey_kinerja

import com.oohyugi.gowit.model.SurveyMdl

/**
 * Created by oohyugi on 13/01/19.
 * github: https://github.com/oohyugi
 */
interface SurveyKinerjaView {
    fun successLoadQuestion(listQuestion: MutableList<SurveyMdl>?)
}
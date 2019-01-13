package com.oohyugi.gowit.model

import com.google.gson.annotations.SerializedName

data class SurveyResultMdl(
                           @SerializedName("question_name")
                     val questionName: String = "",
                           @SerializedName("question_answer")
                     val answer: String = "",
                           @SerializedName("question_id")
                     val questionId: Int = 0)
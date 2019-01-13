package com.oohyugi.gowit.model

import com.google.gson.annotations.SerializedName

data class SurveyMdl(@SerializedName("answer_type")
                     val answerType: String = "",
                     @SerializedName("question_name")
                     val questionName: String = "",
                     @SerializedName("question_answer")
                     val questionAnswer: List<QuestionAnswerItemMdl>?,
                     @SerializedName("question_id")
                     val questionId: Int = 0)
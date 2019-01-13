package com.oohyugi.gowit.model

import com.google.gson.annotations.SerializedName

data class QuestionAnswerItemMdl(@SerializedName("answer_name")
                                 val answerName: String = "",
                                 @SerializedName("answer_id")
                                 val answerId: Int = 0)
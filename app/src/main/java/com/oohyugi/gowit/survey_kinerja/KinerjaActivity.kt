package com.oohyugi.gowit.survey_kinerja

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.oohyugi.gowit.R
import com.oohyugi.gowit.base.BaseActivity
import com.oohyugi.gowit.model.QuestionAnswerItemMdl
import com.oohyugi.gowit.model.SurveyMdl
import android.widget.TextView
import com.google.gson.Gson
import com.oohyugi.gowit.model.SurveyResultMdl
import kotlinx.android.synthetic.main.activity_kinerja.*
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup


class KinerjaActivity : BaseActivity(),SurveyKinerjaView {
    override fun successLoadQuestion(listQuestion: MutableList<SurveyMdl>?) {
        mListQuestion.addAll(listQuestion!!)

        initSurvey()
    }

    private fun initSurvey() {
        var sortedList = mListQuestion.sortedWith(compareBy({ it.questionId }))
//        for ( i in sortedList.indices){
//            if (sortedList[i].answerType == "textfield"){
//                initQuestionTextfield(sortedList[i])
//            }else if (sortedList[i].answerType == "choice"){
//                initQuestionChoice(sortedList[i])
//            }
//        }
        for (item in sortedList) {

            val result = SurveyResultMdl(item.questionName,"",item.questionId)
            mapResult[item.questionId] = result
            if (item.answerType == "textfield" || item.answerType=="textfield_number"){
                initQuestionTextfield(item)
            }
            else if (item.answerType == "choice"){
                initQuestionChoice(item)
            }
        }
    }

    var editTexts: ArrayList<EditText> = ArrayList()
    var etAnswer: EditText? = null
    var mapResult:HashMap<Int,SurveyResultMdl> = hashMapOf()
    private fun initQuestionTextfield(item: SurveyMdl) {

        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.item_textfield,null,false)

        val tvTitle = view.findViewById<TextView>(R.id.tvQuestion)
        val tvNumber = view.findViewById<TextView>(R.id.tvNumber)

        etAnswer = view.findViewById<EditText>(R.id.answerTextfied)
        etAnswer!!.id = item.questionId
        tvTitle.text = "${item.questionName}"
        tvNumber.text = item.questionId.toString()

        if(item.answerType =="textfield_number"){
            etAnswer!!.inputType = InputType.TYPE_CLASS_NUMBER
        }else{
            etAnswer!!.inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
        }
        editTexts.add(etAnswer!!)




        mContainerSurvey.addView(view)
    }

    var radioGroups: ArrayList<RadioGroup> = ArrayList()
    var rGroup: RadioGroup? = null
    private fun initQuestionChoice(item: SurveyMdl) {
        val inflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.item_choice,null,false)

        val listAnswer: MutableList<QuestionAnswerItemMdl> = mutableListOf()
        listAnswer.addAll(item.questionAnswer!!)
        val tvTitle = view.findViewById<TextView>(R.id.tvQuestion)
        val tvNumber = view.findViewById<TextView>(R.id.tvNumber)
        tvTitle.text = "${item.questionName}"
        tvNumber.text = item.questionId.toString()

        rGroup = view.findViewById<RadioGroup>(R.id.radioGroupAnswer)
        rGroup!!.id = item.questionId

        var sortedListAnswer = listAnswer.sortedWith(compareBy { it.answerId })
        for (answer in sortedListAnswer) {
            val rb = RadioButton(this)
            rb.text = answer.answerName
            rb.id = answer.answerId
            rGroup!!.addView(rb)


        }

//        rGroup!!.setOnCheckedChangeListener { p0, p1 ->
//            val radioButtonID = p0.checkedRadioButtonId
//            val radioButton:RadioButton = p0.findViewById(radioButtonID)
//            val idx = p0.indexOfChild(radioButton)
//            val r = p0!!.getChildAt(idx) as RadioButton
//            Log.e("value",r.text.toString())
//            mapResult[rGroup!!.id] =
//                    SurveyResultMdl(mListQuestion[rGroup!!.id-1].questionName,r.text.toString(),mListQuestion[rGroup!!.id-1].questionId)
////
//        }

        radioGroups.add(rGroup!!)

        mContainerSurvey.addView(view)

    }


    var mListQuestion:MutableList<SurveyMdl> = mutableListOf()
    var mListResult:MutableList<SurveyResultMdl> = mutableListOf()
    lateinit var mPresenter: SurveyKinerjaPresenter
    lateinit var mContainerSurvey:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kinerja)
        mContainerSurvey = findViewById(R.id.containerSurvey)
        mPresenter = SurveyKinerjaPresenter(this)
        mPresenter.loadSurveyKinerja(this)

        btnSubmit.setOnClickListener {


            initResult()

        }


    }

    private fun initResult() {

        /**
         * result textfield
         */
        for (editText in editTexts) {
            Log.d("Texts", editText.getText().toString())
            mapResult[editText.id] =
                    SurveyResultMdl(mListQuestion[editText.id-1].questionName,editText.text.toString(),mListQuestion[editText.id-1].questionId)
        }




//        for (radiogroup in radioGroups){
//            val radioButtonID = radiogroup.checkedRadioButtonId
//            val radioButton:RadioButton = radiogroup.findViewById(radioButtonID)
//            val idx = radiogroup.indexOfChild(radioButton)
//            val r = radiogroup!!.getChildAt(idx) as RadioButton
//            Log.d("radio", r.text.toString())
//            mapResult[radiogroup.id-1] =
//                    SurveyResultMdl(mListQuestion[radiogroup.id-1].questionName,r.text.toString(),mListQuestion[radiogroup.id-1].questionId)
//
//        }


//        for (radioGroup in radioGroups)
//        //From the parent layout (Linear Layout) get the child
//        {
//
//                val rg = radioGroup as RadioGroup //create a RadioButton for each group
//                val selectedId = rg.checkedRadioButtonId // get the selected button
//
//                val radiochecked = findViewById<View>(selectedId) as RadioButton
//                Log.e("Radio", radiochecked.text.toString())   //from the button get the selected text
//
//            }
//
//
        Log.e("result",Gson().toJson(mapResult
        ))

    }

    companion object {

        private val TAG_ID = "id"

        fun startThisActivity(context: Context, userId:Int){
            val intent = Intent(context,KinerjaActivity::class.java)
            intent.putExtra(TAG_ID,userId)
            context.startActivity(intent)
        }
    }


}

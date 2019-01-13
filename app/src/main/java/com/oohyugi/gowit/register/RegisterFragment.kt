package com.oohyugi.gowit.register


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup

import com.oohyugi.gowit.R
import kotlinx.android.synthetic.main.fragment_register.*
import android.widget.RadioButton
import android.widget.Toast
import com.google.gson.Gson
import com.oohyugi.gowit.dblocal.user.UserDbHelper
import com.oohyugi.gowit.login.LoginFragment
import com.oohyugi.gowit.model.UserMdl
import com.oohyugi.gowit.replaceFragment


class RegisterFragment : Fragment() {


    var name : String? = null
    var username : String? = null
    var password : String? = null
    var alamat : String? = null
    var jenis_kelamin : String? = null
    var usia : Int = 0
    var pendidikan : String? = null
    var pekerjaan : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDaftar.setOnClickListener {
            initData()
        }

        radioGroupJk.setOnCheckedChangeListener { p0, p1 ->
            val radioButtonID = p0.getCheckedRadioButtonId()
            val radioButton:RadioButton = p0.findViewById(radioButtonID)
            val idx = p0.indexOfChild(radioButton)
            val r = p0!!.getChildAt(idx) as RadioButton
            jenis_kelamin = r.text.toString()
        }
        radioGroupPeker.setOnCheckedChangeListener { p0, p1 ->
            val radioButtonID = p0.getCheckedRadioButtonId()
            val radioButton:RadioButton = p0.findViewById(radioButtonID)
            val idx = p0.indexOfChild(radioButton)
            val r = p0!!.getChildAt(idx) as RadioButton
            pekerjaan = r.text.toString()
        }
        radioGroupPend.setOnCheckedChangeListener { p0, p1 ->
            val radioButtonID = p0.getCheckedRadioButtonId()
            val radioButton:RadioButton = p0.findViewById(radioButtonID)
            val idx = p0.indexOfChild(radioButton)
            val r = p0!!.getChildAt(idx) as RadioButton
            pendidikan = r.text.toString()
        }
    }


    private fun initData() {
        name = etName.text.toString()
        username = etUsername.text.toString()
        password = etPassword.text.toString()
        alamat = etAlamat.text.toString()
        usia = etUsia.text.toString().toInt()
        if (etLainya.text.isNotEmpty()){
            radioGroupPeker.clearCheck()
            pekerjaan = etLainya.text.toString()
        }

        val id = System.currentTimeMillis()/1000
        val dataUser = UserMdl(id.toInt(),name,username,password,alamat,jenis_kelamin,usia,pendidikan,pekerjaan)

        Log.e("data user",Gson().toJson(dataUser))

        UserDbHelper.saveDataUser(dataUser)
        Toast.makeText(context,"Data berhasil di simpan",Toast.LENGTH_SHORT).show()
        LoginFragment.gotoLogin((activity as AppCompatActivity))

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
        fun gotoRegister(activity: AppCompatActivity){
            val frag = RegisterFragment.newInstance()

            activity.replaceFragment(frag,R.id.petaniContainer)
        }
    }
}

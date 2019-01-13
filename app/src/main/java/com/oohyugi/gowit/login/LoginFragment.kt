package com.oohyugi.gowit.login


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson

import com.oohyugi.gowit.R
import com.oohyugi.gowit.dblocal.user.UserDbHelper
import com.oohyugi.gowit.petani.MasterDataFragment
import com.oohyugi.gowit.register.RegisterFragment
import com.oohyugi.gowit.replaceFragment
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    var username:String? = null
    var password:String? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {

            username = etName.text.toString()
            password  = etPassword.text.toString()
            if (UserDbHelper.loginUser(username!!, password!!)!=null){
                MasterDataFragment.gotoMasterData((this.activity as AppCompatActivity),
                    UserDbHelper.loginUser(username!!, password!!)!!
                )
                Log.e("data",Gson().toJson(UserDbHelper.loginUser(username!!, password!!)))
            }else{
                Toast.makeText(context,"Username / password salah",Toast.LENGTH_SHORT).show()
            }


        }

        btnDaftar.setOnClickListener {


            RegisterFragment.gotoRegister((this.activity as AppCompatActivity))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
        fun gotoLogin(activity: AppCompatActivity){
            val fragLogin = LoginFragment.newInstance()

            activity.replaceFragment(fragLogin,R.id.petaniContainer)
        }
    }



}

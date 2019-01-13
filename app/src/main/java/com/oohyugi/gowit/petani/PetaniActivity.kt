package com.oohyugi.gowit.petani

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.oohyugi.gowit.R
import com.oohyugi.gowit.base.BaseActivity
import com.oohyugi.gowit.login.LoginFragment
import com.oohyugi.gowit.replaceFragment
import kotlinx.android.synthetic.main.toolbar.*

class PetaniActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petani)

        supportActionBar!!.title = "Petani"

        val fragLogin = LoginFragment.newInstance()

        this.replaceFragment(fragLogin,R.id.petaniContainer)
    }
}

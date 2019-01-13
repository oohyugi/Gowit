package com.oohyugi.gowit

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by oohyugi on 12/01/19.
 * github: https://github.com/oohyugi
 */


    fun AppCompatActivity.replaceFragment( fragment: Fragment, idContainer: Int) {
        this.supportFragmentManager.beginTransaction()
            .replace(idContainer, fragment)
            .commit()
    }

    fun AppCompatActivity.addFragment(fragment: Fragment, idContainer: Int) {
        this.supportFragmentManager.beginTransaction()
            .add(idContainer, fragment)
            .commit()
    }



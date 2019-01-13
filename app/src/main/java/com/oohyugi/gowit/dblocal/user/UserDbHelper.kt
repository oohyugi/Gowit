package com.oohyugi.gowit.dblocal.user

import android.annotation.SuppressLint
import com.oohyugi.gowit.model.UserMdl
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by oohyugi on 12/01/19.
 * github: https://github.com/oohyugi
 */
object UserDbHelper {

    @SuppressLint("StaticFieldLeak")
    var realm = Realm.getDefaultInstance()


    fun saveDataUser(data:UserMdl){
        realm.beginTransaction()

        val user = UserRealmMdl()
        user.id = data.id
        user.name = data.name
        user.username = data.username
        user.password = data.password
        user.alamat = data.alamat
        user.jenis_kelamin = data.jenis_kelamin
        user.pekerjaan = data.pekerjaan
        user.pendidikan = data.pendidikan
        user.usia = data.usia

//        val user = UserRealmMdl(data.id,data.name,data.username,data.password,data.alamat,data.jenis_kelamin,data.usia,data.pendidikan,data.pekerjaan)
        realm.copyToRealm(user)
        realm.commitTransaction()

    }

    fun loginUser(userName:String,password:String):UserMdl?{
        val user: UserRealmMdl? = realm.where(UserRealmMdl::class.java).equalTo("username",userName).equalTo("password",password).findFirst()

        var responseUser: UserMdl? = null
        if (user!=null){

            responseUser = UserMdl(user.id,user.name,user.username,user.password,user.alamat,user.jenis_kelamin,user.usia,user.pendidikan,user.pekerjaan)

        }
        return responseUser

    }

    fun getUser(id:Int):UserMdl?{
        realm.beginTransaction()
        val user: UserRealmMdl? = realm.where(UserRealmMdl::class.java).equalTo("id",id).findFirst()

        var responseUser: UserMdl? = null
        if (user!=null){

            responseUser = UserMdl(user.id,user.name,user.username,user.password,user.alamat,user.jenis_kelamin,user.usia,user.pendidikan,user.pekerjaan)

        }

        return responseUser


    }
}


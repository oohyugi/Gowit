package com.oohyugi.gowit.dblocal.user

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 * Created by oohyugi on 12/01/19.
 * github: https://github.com/oohyugi
 */
open class UserRealmMdl:RealmObject(){
    @PrimaryKey @JvmField  var id : Int? =0
    @JvmField
    var name : String? = null

    @JvmField
    var username : String? = null

    @JvmField
    var password : String? = null

    @JvmField
    var alamat : String? = null

    @JvmField
    var jenis_kelamin : String? = null

    @JvmField
    var usia : Int = 0

    @JvmField
    var pendidikan : String? = null

    @JvmField
    var pekerjaan : String? = null
}
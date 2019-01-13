package com.oohyugi.gowit.model

import java.io.Serializable

/**
 * Created by oohyugi on 12/01/19.
 * github: https://github.com/oohyugi
 */
data class UserMdl (
    val id : Int? =0,
    val name : String?,
    val username : String?,
    val password : String?,
    val alamat : String?,
    val jenis_kelamin : String?,
    val usia : Int,
    val pendidikan : String?,
    val pekerjaan : String?

):Serializable
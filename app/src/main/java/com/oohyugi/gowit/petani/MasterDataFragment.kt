package com.oohyugi.gowit.petani


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oohyugi.gowit.R
import com.oohyugi.gowit.dblocal.user.UserDbHelper
import com.oohyugi.gowit.model.UserMdl
import com.oohyugi.gowit.register.RegisterFragment
import com.oohyugi.gowit.replaceFragment
import com.oohyugi.gowit.survey_kinerja.KinerjaActivity
import kotlinx.android.synthetic.main.fragment_master_data.*

class MasterDataFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master_data, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user: UserMdl = arguments!!.getSerializable(TAG_USER) as UserMdl
        tvName.text = user.name
        tvAlamat.text = user.alamat
        tvJk.text = user.jenis_kelamin
        tvPekerjaan.text = user.pekerjaan
        tvPendidikan.text = user.pendidikan
        tvUsia.text  = "${user.usia} Tahun"

        btnKinerja.setOnClickListener {
            KinerjaActivity.startThisActivity(activity!!, user.id!!)
        }

    }


    companion object {
        val TAG_USER="user"
        @JvmStatic
        fun newInstance(user:UserMdl) =
            MasterDataFragment().apply {
                arguments = Bundle().apply {

                    putSerializable(TAG_USER,user)
                }
            }

        fun gotoMasterData(activity: AppCompatActivity, user: UserMdl){
            val frag = MasterDataFragment.newInstance(user)

            activity.replaceFragment(frag,R.id.petaniContainer)
        }
    }
}

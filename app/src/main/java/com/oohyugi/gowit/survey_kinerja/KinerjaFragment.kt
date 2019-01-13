package com.oohyugi.gowit.survey_kinerja


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.oohyugi.gowit.R
import com.oohyugi.gowit.model.UserMdl
import com.oohyugi.gowit.petani.MasterDataFragment
import com.oohyugi.gowit.replaceFragment


private const val ARG_USERID = "userId"


class KinerjaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var userId: Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getInt(ARG_USERID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kinerja, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment KinerjaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            KinerjaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_USERID, param1)
                }
            }

        fun gotoKinerja(activity: AppCompatActivity, userId: Int){
            val frag = KinerjaFragment.newInstance(userId)

            activity.replaceFragment(frag,R.id.petaniContainer)
        }
    }
}

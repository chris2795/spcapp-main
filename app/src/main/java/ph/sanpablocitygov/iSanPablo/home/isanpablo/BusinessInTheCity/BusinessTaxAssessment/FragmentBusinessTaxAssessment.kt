package ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity.BusinessTaxAssessment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ph.sanpablocitygov.iSanPablo.R

class FragmentBusinessTaxAssessment : Fragment() {

    @SuppressLint("SetTextI18n", "InflateParams")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.bc_assessment_login_fragment, container, false)
      //  val btnreg = view.findViewById<TextView>(R.id.txt_assessment_register)
//        btnreg.setOnClickListener {
//            activity!!.supportFragmentManager.beginTransaction().replace(
//                R.id.frag_container,
//                FragmentBusinessTaxAssessmentRegistration() , null)
//                .addToBackStack(null)
//                .commit()
//        }
//        val btnreg = view.findViewById(R.id.txt_assessment_register) as TextView
//        btnreg.setOnClickListener(object: View.OnClickListener {
//
//            override fun onClick(v:View) {
//                val `in` = Intent(getActivity(), BusinessTaxAssessmentRegActivity::class.java)
//                startActivity(`in`)
//            }
//        })



        return view


    }
}
package ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity.Amendments

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ph.sanpablocitygov.iSanPablo.R
import ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity.BPLO.FragmentBPLOProfile

class FragmentAmendments1 : Fragment() {

    @SuppressLint("SetTextI18n", "InflateParams")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_bc_amendments, container, false)

//        btnreg.setOnClickListener(object: View.OnClickListener {
//
//            override fun onClick(v:View) {
//                val `in` = Intent(getActivity(), BusinessTaxAssessmentRegActivity::class.java)
//                startActivity(`in`)
//            }
//        })

        val btnreg = view.findViewById<TextView>(R.id.txt_amen_back)
        btnreg.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentBPLOProfile() , null)
                .addToBackStack(null)
                .commit()
        }

        return view


    }
}
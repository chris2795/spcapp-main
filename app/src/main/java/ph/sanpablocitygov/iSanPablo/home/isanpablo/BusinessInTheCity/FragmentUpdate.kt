package ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity


import android.os.Bundle
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ph.sanpablocitygov.iSanPablo.R


class FragmentUpdate : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.update_fragment, null)

        return view
    }
}

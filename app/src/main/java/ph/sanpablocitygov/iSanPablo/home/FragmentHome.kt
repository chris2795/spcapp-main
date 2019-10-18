package ph.sanpablocitygov.iSanPablo.home

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import ph.sanpablocitygov.iSanPablo.R
import ph.sanpablocitygov.iSanPablo.links.*

import layout.ph.sanpablocitygov.iSanPablo.goverment.FragmentCityHotline
import ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity.BPLO.Loginbplo.FragmentBPLOAccountReg
import ph.sanpablocitygov.iSanPablo.home.isanpablo.BusinessInTheCity.FragmentBusinessInTheCity
import ph.sanpablocitygov.iSanPablo.home.isanpablo.FragmentCityEmployeesCorner
import ph.sanpablocitygov.iSanPablo.home.isanpablo.GovernmentOnlineServices.FragmentGovermentOnlineServices
import ph.sanpablocitygov.iSanPablo.home.isanpablo.MyAppOnlineRequest.FragmentMyAppOnlineRequest
import ph.sanpablocitygov.iSanPablo.home.isanpablo.FragmentMyTaxes.FragmentMyTaxes
import ph.sanpablocitygov.iSanPablo.home.isanpablo.test

@Suppress("UNREACHABLE_CODE", "PLUGIN_WARNING")
class FragmentHome : Fragment() {

    internal lateinit var viewflipperHome : ViewFlipper
    private var permissionsRequired = arrayOf( Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val PERMISSION_CALLBACK_CONSTANT = 100
    private val REQUEST_PERMISSION_SETTING = 101
    private var permissionStatus: SharedPreferences? = null
    private var sentToSettings = false
    internal lateinit var viewPagerHome: ViewPager
    internal lateinit var viewPagerEvents: ViewPager
    internal lateinit var viewflipperEvents : ViewFlipper

  val image = intArrayOf(R.drawable.lake5,R.drawable.lake1,R.drawable.lake4,R.drawable.lake2)

    val imageevent = intArrayOf(R.drawable.event1,R.drawable.event2,R.drawable.event3)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home_layout_2, null)

       viewflipperHome =view.findViewById<View>(R.id.v_flipper) as ViewFlipper

        viewflipperEvents =view.findViewById<View>(R.id.v_flipperevent) as ViewFlipper

        permissionStatus = activity!!.getSharedPreferences("permissionStatus", Context.MODE_PRIVATE)
        requestPermission()
//        val linear = view.findViewById<LinearLayout>(R.id.linear_buss)
//        linear.animation = AnimationUtils.loadAnimation(requireContext(),R.anim.fade_scale_animation)

        for(i in 0 until image.size) {
            flip_imagehome(image[i])
        }
//

        for(i in 0 until imageevent.size) {
            flip_imageevent(imageevent[i])
        }

//        viewPagerEvents = view.findViewById<View>(R.id.events_viewpager) as ViewPager
//        val adapterevents = ViewPagerAdapterEvent(requireContext())
//        viewPagerEvents.adapter = adapterevents
//
//        viewPagerHome = view?.findViewById<View>(R.id.home_viewpager) as ViewPager
//        val adapterhome = ViewPageAdapterHome(requireContext())
//        viewPagerHome.adapter = adapterhome

        val btncsc = view.findViewById<Button>(R.id.btn_home_csc)
        btncsc?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentHomeCSC() , null)
                .addToBackStack(null)
                .commit()
        }
        val btnphiljob = view.findViewById<Button>(R.id.btn_home_phil_job)
        btnphiljob?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentHomePhilJobNet() , null)
                .addToBackStack(null)
                .commit()
        }


        val btnweb = view.findViewById<Button>(R.id.db_home_logo)
        btnweb?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                Fragmentweb() , null)
                .addToBackStack(null)
                .commit()
        }

        val btngeps = view.findViewById<android.widget.Button>(R.id.btn_home_philgeps)
        btngeps?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentHomePhilGEPS()
                , null)
                .addToBackStack(null)
                .commit()
        }
        val btncio = view.findViewById<android.widget.Button>(R.id.btn_fb_cio)
        btncio?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentFBCIO()
                , null)
                .addToBackStack(null)
                .commit()
        }
        val textcio = view.findViewById<TextView>(R.id.text_fb_cio)
        textcio?.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentFBCIO()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textBITC = view.findViewById<TextView>(R.id.btn_business_in_the_city)
        textBITC.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentBusinessInTheCity()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textMT = view.findViewById<TextView>(R.id.btn_my_taxes)
        textMT.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentMyTaxes()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textGOS = view.findViewById<TextView>(R.id.btn_gov_online_service)
        textGOS.setOnClickListener { activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentGovermentOnlineServices()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textMAOR = view.findViewById<TextView>(R.id.btn_online_request)
        textMAOR.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentMyAppOnlineRequest()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textCH = view.findViewById<TextView>(R.id.btn_city_hot_lines)
        textCH.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentCityHotline()
                , null)
                .addToBackStack(null)
                .commit()
        }

        val textCEC = view.findViewById<TextView>(R.id.btn_city_employees_corner)
        textCEC.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction().replace(
                R.id.frag_container,
                FragmentCityEmployeesCorner()
                , null)
                .addToBackStack(null)
                .commit()
        }



        return view

    }


    private fun requestPermission() {
        if (ActivityCompat.checkSelfPermission(requireContext(), permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(requireContext(), permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(requireContext(), permissionsRequired[2]) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[0])
                || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[1])
                || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[2])) {
                //Show Information about why you need the permission

            } else if (permissionStatus!!.getBoolean(permissionsRequired[0], false)) {
                //Previously Permission Request was cancelled with 'Dont Ask Again',
                // Redirect to Settings after showing Information about why you need the permission
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Need Multiple Permissions")
                builder.setMessage("This app needs permissions.")
                builder.setPositiveButton("Grant") { dialog, which ->
                    dialog.cancel()
                    sentToSettings = true
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)

                    startActivityForResult(intent, REQUEST_PERMISSION_SETTING)
                    Toast.makeText(requireContext(), "Go to Permissions to Grant ", Toast.LENGTH_LONG).show()
                }
                builder.setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }
                builder.show()
            } else {
                //just request the permission
                ActivityCompat.requestPermissions(requireActivity(), permissionsRequired, PERMISSION_CALLBACK_CONSTANT)
            }

            //   txtPermissions.setText("Permissions Required")

            val editor = permissionStatus!!.edit()
            editor.putBoolean(permissionsRequired[0], true)
            editor.commit()
        } else {
            //You already have the permission, just go ahead.

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_CALLBACK_CONSTANT) {
            //check if all permissions are granted
            var allgranted = false
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    allgranted = true
                } else {
                    allgranted = false
                    break
                }
            }

            if (allgranted) {

            } else if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[0])
                || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[1])
                || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), permissionsRequired[2])) {

            } else {
                Toast.makeText(requireContext(), "Unable to get Permission", Toast.LENGTH_LONG).show()
            }
        }
    }



    //
    fun flip_imagehome(i : Int) {
        val view = ImageView(context)
        view.setBackgroundResource(i)
        viewflipperHome.addView(view)
        viewflipperHome.setFlipInterval(5000)
        viewflipperHome.setAutoStart(true)
        viewflipperHome.setInAnimation(context , android.R.anim.slide_in_left)
        viewflipperHome.setOutAnimation(context , android.R.anim.slide_out_right)
    }


    fun flip_imageevent(i : Int) {
        val view = ImageView(context)
        view.setBackgroundResource(i)
        viewflipperEvents.addView(view)
        viewflipperEvents.setFlipInterval(7000)
        viewflipperEvents.setAutoStart(true)
        viewflipperEvents.setInAnimation(context , android.R.anim.slide_in_left)
        viewflipperEvents.setOutAnimation(context , android.R.anim.slide_out_right)
    }


}


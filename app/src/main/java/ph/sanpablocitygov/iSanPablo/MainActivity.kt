package ph.sanpablocitygov.iSanPablo

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.MenuItem
import ph.sanpablocitygov.iSanPablo.goverment.department.FragmentDepartment
import ph.sanpablocitygov.iSanPablo.home.FragmentHome
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.dialog_disclosure.view.*
import kotlinx.android.synthetic.main.dialog_my_isanpablo.view.*
import layout.FragmentMyTaxes
import layout.ph.sanpablocitygov.iSanPablo.FragmentCityEmployeesCorner
import layout.ph.sanpablocitygov.iSanPablo.FragmentMyAppOnlineRequest
import layout.ph.sanpablocitygov.iSanPablo.goverment.FragmentCityHotline

import layout.ph.sanpablocitygov.iSanPablo.goverment.department.FragmentGovermentOnlineServices
import ph.sanpablocitygov.iSanPablo.OurGovernment.FragmentOurGoverment
import ph.sanpablocitygov.iSanPablo.home.BusinessPermit.FragmentBusinessPermit
import ph.sanpablocitygov.iSanPablo.links.*
//import ph.sanpablocitygov.iSanPablo.tourism.FragmentTourism

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


//    internal var expandableListView: ExpandableListView? = null
//    internal var adapter: ExpandableListAdapter? = null
//    internal var titleList: List<String> ? = null
//    val data: HashMap<String, List<String>>
//
//        get() {
//            val listData = HashMap<String, List<String>>()
//            val theTourism = ArrayList<String>()
//            theTourism.add("Tourism Master Plan")
//            theTourism.add("Gallery")
//            theTourism.add("Landmarks")
//            theTourism.add("Events")
//            val theHome = ArrayList<String>()
//
//            val theCity = ArrayList<String>()
//            theCity.add("History")
//            theCity.add("San Pableños")
//            theCity.add("Barangay")
//            theCity.add("Hymn")
//            theCity.add("Location")
//            theCity.add("Mission and Vision")
//
//            val theGoverment = ArrayList<String>()
//            theGoverment.add("Office Vicinity Map")
//            theGoverment.add("Local Officials")
//            theGoverment.add("Departments")
//
//            val theEconomy = ArrayList<String>()
//            theEconomy.add("Comprehensive Land Usage Program Vol. 1")
//            theEconomy.add("Comprehensive Land Usage Program Vol. 2")
//            theEconomy.add("Comprehensive Land Usage Program Vol. 3")
//            theEconomy.add("Comprehensive Development Plan")
//            theEconomy.add("SPC Ecological Profile")
//            theEconomy.add("CDP Annexes")
//
//
//
//            val theOthers = ArrayList<String>()
//            theOthers.add("Citizen's Charter")
//            theOthers.add("Browser")
//
//            val theFillup = ArrayList<String>()
//            theFillup.add("BPLO Fill Up")
//
//            val theAbout = ArrayList<String>()
//            theAbout.add("GOV.PH")
//            theAbout.add("Open Data Portal")
//            theAbout.add("Official Gazette")
//
//            val theLinks = ArrayList<String>()
//            theLinks.add("Office of the President")
//            theLinks.add("Office of the Vice President")
//            theLinks.add("Senate of the Philippines")
//            theLinks.add("House of Representatives")
//            theLinks.add("Supreme Court")
//            theLinks.add("Court of the Appeals")
//            theLinks.add("Sandiganbayan")
//
//
//
//            listData["Goverment"] = theCity
//            listData["Economy"] = theEconomy
//            listData["Home"] = theHome
//            listData["The City"] = theCity
//            listData["Tourism"] = theTourism
//
//            listData["Others"] = theOthers
//            listData["Fill Up Forms"] = theFillup
//            listData["About GOVPH"] = theAbout
//            listData["Government Links"] = theLinks
//
//            return listData
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            var show: Any = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        val navView: NavigationView = findViewById(R.id.nav_view)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
       supportFragmentManager.beginTransaction().replace(
           R.id.frag_container,
           FragmentHome()
       ).commit()


//
//        var mdrawerlayout = findViewById<DrawerLayout>(R.id.drawer_layout)
//        var expandableListview = findViewById<ExpandableListView>(R.id.expendableListView)


//        expandableListView = findViewById(R.id.expendableListView)
//        if (expandableListView != null) {
//            val listData = data
//            titleList = ArrayList(listData.keys)
//            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
//            expandableListView!!.setAdapter(adapter)
//
//            expandableListView!!.setOnGroupExpandListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show() }
//
//            expandableListView!!.setOnGroupCollapseListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show() }
//
//            expandableListView!!.setOnChildClickListener { _, _, groupPosition, childPosition, _ ->
//                Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
//                false
//            }
//        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


//
//
//    val police = "09081930819"
//    val emergency = "09089078124"
//    val fire = "09995784943"
//    val PHONE_REQ = 1
//
    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {

//
//        R.id.police_menu -> {
//
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.CALL_PHONE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)
//
//            } else {
//
//                policecall()
//            }
//
//            true
//        }

//        R.id.emergency_menu -> {
//
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.CALL_PHONE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)
//            } else {
//                emergencycall()
//            }
//            true
//        }

//        R.id.fire_menu -> {
//
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.CALL_PHONE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//
//                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)
//            } else {
//
//                firecall()
//            }
//            true
//        }
//
//        R.id.admin -> {
//
//        spc_map()
//
//            true
//        }


        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }

    }

//    private fun policecall() {
//        val callIntent = Intent(Intent.ACTION_CALL)
//        callIntent.data = Uri.parse("tel:" + police)
//
//        startActivity(callIntent)
//    }
//
////    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
////        if(requestCode == PHONE_REQ)policecall()
////
////    }
//
//
//    private fun emergencycall(){
//        val callIntent =Intent(Intent.ACTION_CALL)
//        callIntent.data = Uri.parse("tel:" + emergency)
//
//        startActivity(callIntent)
//    }
//
//    private fun firecall(){
//        val callIntent = Intent(Intent.ACTION_CALL)
//        callIntent.data = Uri.parse("tel:" + fire)
//
//        startActivity(callIntent)
//    }
//
//    private fun spc_map(){
//        supportFragmentManager.beginTransaction().replace(
//            R.id.frag_container,
//            FragmentGoogleMap()
//        ).commit()
//
//    }
//
//


//    @SuppressLint("CommitTransaction")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentHome()
                ).commit()
            }
            R.id.nav_our_city -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOurCity()
                ).commit()
            }
            R.id.nav_our_government -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOurGoverment()
                ).commit()
            }

            R.id.nav_department_head -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentDepartment()
                ).commit()
            }

            R.id.nav_full_disclosure -> {

                    val disView = LayoutInflater.from(this).inflate(R.layout.dialog_disclosure, null)
                    val disBuilder = AlertDialog.Builder(this)
                        .setView(disView)
                    val disDialog = disBuilder.show()

                disView.disclosure_1.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("4th-quarter-SPP")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/4th-qtr-SPP.xls")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

                disView.disclosure_2.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("20-utilization-2018-4th-Quarter")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/20-Uitlization-2018-4th-Quarter.xls")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }


                disView.disclosure_3.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("APP-2019")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/APP-2019.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }


                disView.disclosure_4.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("BID-RESULTS 2018 4th Quarter")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/BID-RESULTS%202018%204th%20Quarter.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }


                disView.disclosure_5.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("SFC-4THQ")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/SCF-4THQ.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }


                disView.disclosure_6.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("SEF-Utilization-2018")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/SEF-Utilization-2018.xls")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }


                disView.disclosure_7.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("Statement of Debt Service 03.24.14")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/Statement%20of%20Debt%20Services%2003.24.14.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

                disView.disclosure_8.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("Unliquidated-2018")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/Unliquidated-2018.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

                disView.disclosure_9.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("CDRRMF-12.31.18")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/CDRRMF-12.31.18.xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

                disView.disclosure_10.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("Manpower Complement(DILG)")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/Manpower%20Complement%20(DILG).xlsx")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

                disView.disclosure_11.setOnClickListener {
                    disDialog.dismiss()
                    var str = "Would you like to download this document?"
                    val builder = AlertDialog.Builder((this))
                    with(builder) {
                        setMessage(str)
                        setTitle("PDAF UTILIZATION")

                        setPositiveButton("OK", DialogInterface.OnClickListener
                        { dialog, which ->  val downloadManager: DownloadManager = ContextCompat.getSystemService(
                            this@MainActivity,
                            DownloadManager::class.java) as DownloadManager
                            val uri = Uri.parse("http://www.sanpablocitygov.ph/docs/PDAF%20UTILIZATION.xls")
                            val request = DownloadManager.Request(uri)
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                            downloadManager.enqueue(request)  })
                        setNegativeButton("CANCEL", null)
                    }
                    val alertDialog = builder.create()

                    alertDialog.show()
                }

            }

            R.id.nav_My_I_San_Pablo-> {

                val disView = LayoutInflater.from(this).inflate(R.layout.dialog_my_isanpablo, null)
                val disBuilder = AlertDialog.Builder(this)
                    .setView(disView)
                val disDialog = disBuilder.show()

                disView.btn_business_in_the_city.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentBusinessPermit()
                    ).commit()

                }

                disView.btn_my_taxes.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentFillUp()
                    ).commit()

                }
                disView.btn_my_taxes.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentMyTaxes()
                    ).commit()

                }
                disView.btn_online_request.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentMyAppOnlineRequest()
                    ).commit()

                }

                disView.btn_city_hot_lines.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentCityHotline()
                    ).commit()

                }

                disView.btn_gov_online_service.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentGovermentOnlineServices()
                    ).commit()

                }

                disView.btn_city_employees_corner.setOnClickListener {
                    disDialog.dismiss()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frag_container,
                        FragmentCityEmployeesCorner()
                    ).commit()

                }

                disView.btn_cancel.setOnClickListener {
                    disDialog.dismiss()
                }

            }



            R.id.nav_webview ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentBrowser()
                ).commit()
            }

            R.id.nav_bplo ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentFillUp()
                ).commit()
            }

            R.id.nav_govph ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentGOV()
                ).commit()
            }
            R.id.nav_open_data ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOpenData()
                ).commit()
            }
            R.id.nav_official_gazette ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOfficialGazette()
                ).commit()
            }

            R.id.nav_president ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOfficePresident()
                ).commit()
            }
            R.id.nav_vice_president ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentOfficeVice()
                ).commit()
            }
            R.id.nav_senate ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentSenate()
                ).commit()
            }
            R.id.nav_representatives ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentRepresentatives()
                ).commit()
            }
            R.id.nav_supreme_court ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentSupremeCourt()
                ).commit()
            }
            R.id.nav_court ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentCourtAppeals()
                ).commit()
            }
            R.id.nav_sandiganbayan ->{
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentSandiganbayan()
                ).commit()
            }

            else -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container,
                    FragmentHome()
                ).commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}


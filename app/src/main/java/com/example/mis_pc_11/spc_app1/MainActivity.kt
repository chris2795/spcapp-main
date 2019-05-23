package com.example.mis_pc_11.spc_app1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.mis_pc_11.spc_app1.Goverment.FragmentEconomy
import com.example.mis_pc_11.spc_app1.Links.*
import com.example.mis_pc_11.spc_app1.TheCity.Barangay.FragmentBarangay
import com.example.mis_pc_11.spc_app1.TheCity.FragmentHistory
import com.example.mis_pc_11.spc_app1.TheCity.FragmentHymn
import com.example.mis_pc_11.spc_app1.TheCity.FragmentLocationTopology
import com.example.mis_pc_11.spc_app1.TheCity.MissionVision
import com.example.mis_pc_11.spc_app1.TheCity.SanPablenos.FragmentSanPablo
import com.example.mis_pc_11.spc_app1.Tourism.Gallery.FragmentGallery
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            var show: Any = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

       supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentHome()).commit()


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    val police = "8004503"
    val emergency = "171"
    val fire = "801-8955"
    val PHONE_REQ = 1

    // actions on click menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {


        R.id.police_menu -> {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)

            } else {

                policecall()
            }

            true
        }

        R.id.emergency_menu -> {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)
            } else {
                emergencycall()
            }
            true
        }

        R.id.fire_menu -> {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), PHONE_REQ)
            } else {

                firecall()
            }
            true
        }

        R.id.spc_map -> {

        spc_map()

            true
        }


        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }

    }

    private fun policecall() {
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + police)

        startActivity(callIntent)
    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        if(requestCode == PHONE_REQ)policecall()
//
//    }


    private fun emergencycall(){
        val callIntent =Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + emergency)

        startActivity(callIntent)
    }

    private fun firecall(){
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:" + fire)

        startActivity(callIntent)
    }

    private fun spc_map(){
        supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentGoogleMap()).commit()

    }




    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentHome()).commit()
            }

            R.id.nav_economy ->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentEconomy()
                ).commit()
            }
            R.id.nav_history->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentHistory()
                ).commit()
            }
            R.id.nav_barangay->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentBarangay()
                ).commit()
            }
            R.id.nav_location->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentLocationTopology()
                ).commit()
            }
            R.id.nav_hymn->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentHymn()
                ).commit()
            }
            R.id.nav_sanpablo->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentSanPablo()
                ).commit()
            }
            R.id.nav_mission->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    MissionVision()
                ).commit()
            }

//            R.id.nav_tourism->{
//                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
//                    FragmentTourism()
//                ).commit()
//            }
            R.id.nav_gallery->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentGallery()
                ).commit()
            }


            R.id.nav_webview->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentBrowser()).commit()
            }

            R.id.nav_bplo->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentFillUp()).commit()
            }

            R.id.nav_govph->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentGOV()
                ).commit()
            }
            R.id.nav_open_data->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentOpenData()
                ).commit()
            }
            R.id.nav_official_gazette->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentOfficialGazette()
                ).commit()
            }

            R.id.nav_president->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentOfficePresident()
                ).commit()
            }
            R.id.nav_vice_president->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentOfficeVice()
                ).commit()
            }
            R.id.nav_senate->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentSenate()
                ).commit()
            }
            R.id.nav_representatives->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentRepresentatives()
                ).commit()
            }
            R.id.nav_supreme_court->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentSupremeCourt()
                ).commit()
            }
            R.id.nav_court->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentCourtAppeals()
                ).commit()
            }
            R.id.nav_sandiganbayan->{
                supportFragmentManager.beginTransaction().replace(R.id.frag_container,
                    FragmentSandiganbayan()
                ).commit()
            }

            else -> {
                supportFragmentManager.beginTransaction().replace(R.id.frag_container, FragmentHome()).commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}


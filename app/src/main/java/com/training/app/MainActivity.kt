package com.training.app

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.training.app.listeners.PermissionListener
import com.training.app.utils.PermissionsManager

class MainActivity : AppCompatActivity() , PermissionListener {


    /*
    https://gist.github.com/nosix/532c51d3568d90dfba5222edb1e689d8
     */
    companion object {
        const val REQUEST_PERMISSION = 1
    }

    private val permissionManager: PermissionsManager by lazy {
        PermissionsManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * this is the first way to implement the listener
         */
        permissionManager.addListener(this)

        /**
         * this is the secnod way to implement the listener
         */
//        permissionManager.addListener(object : PermissionListener {
//            override fun onPermissionGenerated() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onPermissionNotGenerated() {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//        })

        /**
         * Check The Permission Status if this permission generated or not
         */
        if (permissionManager.checkPermissionIfGenrated(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Permission Generated", Toast.LENGTH_SHORT).show()
        } else {

            /**
             * request permissoin
             */
            permissionManager.requestPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                REQUEST_PERMISSION
            )
        }

    }


    /**
     * check the result permission
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionManager.onRequestPermissionsResult(this , requestCode, permissions, grantResults)
    }

    override fun onPermissionNotGenerated() {
        Toast.makeText(this, "Permission Generated", Toast.LENGTH_SHORT).show()
    }

    override fun onPermissionGenerated() {
        Toast.makeText(this, "Permission Not Generated", Toast.LENGTH_SHORT).show()
    }

}
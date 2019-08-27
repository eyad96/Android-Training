package com.training.app.utils

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.training.app.MainActivity
import com.training.app.listeners.PermissionListener

class PermissionsManager {

    private lateinit var listener: PermissionListener

    fun checkPermissionIfGenrated(context: Context , permission: String): Boolean =
        ContextCompat.checkSelfPermission(context , permission) != PackageManager.PERMISSION_GRANTED

    fun requestPermission(context: AppCompatActivity , permission: String , requestCode: Int) {
        ActivityCompat.requestPermissions(context , arrayOf(permission) , requestCode)
    }

    fun onRequestPermissionsResult(context: Context , requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            MainActivity.REQUEST_PERMISSION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                listener.onPermissionGenerated()
            } else {
                listener.onPermissionNotGenerated()
            }
        }
    }

    fun addListener(listener: PermissionListener) {
        this.listener = listener
    }

}
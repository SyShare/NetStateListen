package com.qiaomu.permissionprocessor

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.qiaomu.annotation.NetChangeState
import com.qiaomu.libpermission.NetMode
import com.qiaomu.libpermission.annotation.RegisterInjectEvent

/**
 * Created by qiaomu on 2017/10/9.
 */
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.sdcardTip).setOnClickListener {
            //                if (!PermissionHelper.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 103)) {
//                    PermissionHelper.requestPermissions(MainActivity.this, 103, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                }

            register()
        }
        findViewById<View>(R.id.phone).setOnClickListener {
            //                PermissionHelper.requestPermissions(MainActivity.this, 100, Manifest.permission.CALL_PHONE);
        }
        findViewById<View>(R.id.sdcard).setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            //                PermissionHelper.requestPermissions(MainActivity.this, 101, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
//        registerObserver(this)
    }

    @RegisterInjectEvent(mode = NetMode.REGISTER_MODE)
    fun register(){

    }

    @NetChangeState
    fun onNetState(isAvailable: Boolean) {
        Toast.makeText(this, "sdcard denied", Toast.LENGTH_SHORT).show()
    }

    @RegisterInjectEvent(mode = NetMode.UN_REGISTER_MODE)
    override fun onDestroy() {
        super.onDestroy()
//        unRegisterObserver(this)
    }
}
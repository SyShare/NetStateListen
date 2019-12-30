package com.qiaomu.permissionprocessor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.qiaomu.annotation.NetChangeState
import com.qiaomu.libpermission.NetStateHelper.registerObserver
import com.qiaomu.libpermission.NetStateHelper.unRegisterObserver

/**
 * Created by qiaomu on 2017/10/9.
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.sdcardTip).setOnClickListener {
            //                if (!PermissionHelper.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 103)) {
//                    PermissionHelper.requestPermissions(MainActivity.this, 103, Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                }
        }
        findViewById<View>(R.id.phone).setOnClickListener {
            //                PermissionHelper.requestPermissions(MainActivity.this, 100, Manifest.permission.CALL_PHONE);
        }
        findViewById<View>(R.id.sdcard).setOnClickListener {
            //                PermissionHelper.requestPermissions(MainActivity.this, 101, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        findViewById<View>(R.id.multi).setOnClickListener {
            //                PermissionHelper.requestPermissions(MainActivity.this, 102, Manifest.permission.READ_SMS,
//                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.SEND_SMS);
        }
        registerObserver(this)
    }

    @NetChangeState
    fun whyNeedSdCard() {
        Toast.makeText(this, "I need write news to sdcard!", Toast.LENGTH_SHORT).show()
    }

    @NetChangeState
    fun onNetState(isAvailable: Boolean) {
        Toast.makeText(this, "sdcard denied", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterObserver(this)
    }
}
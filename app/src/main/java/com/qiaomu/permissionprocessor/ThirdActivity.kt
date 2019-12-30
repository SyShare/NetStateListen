package com.qiaomu.permissionprocessor

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.qiaomu.annotation.NetChangeState
import com.qiaomu.libpermission.NetMode
import com.qiaomu.libpermission.NetStateHelper.registerObserver
import com.qiaomu.libpermission.NetStateHelper.unRegisterObserver
import com.qiaomu.libpermission.annotation.RegisterInjectEvent

/**
 * Created by qiaomu on 2017/10/9.
 */
class ThirdActivity : AppCompatActivity() {

    @RegisterInjectEvent(mode = NetMode.REGISTER_MODE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.sdcardTip).setOnClickListener {
        }

    }

    @NetChangeState
    fun onNetState(isAvailable: Boolean) {
        Toast.makeText(this, "ThirdActivity", Toast.LENGTH_SHORT).show()
    }

    @RegisterInjectEvent(mode = NetMode.UN_REGISTER_MODE)
    override fun onDestroy() {
        super.onDestroy()
    }
}
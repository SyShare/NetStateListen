package com.qiaomu.permissionprocessor

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.qiaomu.annotation.NetChangeState
import com.qiaomu.libpermission.NetMode
import com.qiaomu.libpermission.NetStateHelper
import com.qiaomu.libpermission.annotation.RegisterInjectEvent
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by qiaomu on 2017/10/9.
 */
class MainActivity : AppCompatActivity() {


    @RegisterInjectEvent(mode = NetMode.REGISTER_MODE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.sdcardTip).setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
        MusicPlayer.setOnClickListener {
            startActivity(Intent(this@MainActivity, MusicPlayerActivity::class.java))
        }
    }


    @NetChangeState
    fun onNetState(isAvailable: Boolean) {
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show()
    }

    @RegisterInjectEvent(mode = NetMode.UN_REGISTER_MODE)
    override fun onDestroy() {
        super.onDestroy()
    }
}
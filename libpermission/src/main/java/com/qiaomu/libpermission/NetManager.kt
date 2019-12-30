package com.qiaomu.libpermission

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.widget.Toast

/**
 * Administrator create by 2019/12/26
 * not easy to coding
 * please don't modify at will!
 */
const val TAG = "NetManager"

object NetManager {

    private var netReceiver: NetworkReceiver? = null

    fun unReister(app: Application) {
        netReceiver?.let {
            app.unregisterReceiver(it)
        }
    }

    /**
     * 注册广播
     */
    fun registerNetChange(app: Application) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            NetStatusMonitor.setNetStatusListener(object : NetStatusMonitor.Listener {

                override fun onLost() {
                    Toast.makeText(AppCont.context, "请检查您的网络状况", Toast.LENGTH_LONG).show()
                    NetStateHelper.dispatchNetStateList(false)
                }

                override fun onAvailable() {
                    NetStateHelper.dispatchNetStateList(true)
                }

                override fun onNetStateChange(oldState: Int, newState: Int) {

                }

            })
        } else {
            if (netReceiver == null) {
                netReceiver = NetworkReceiver()
                val intentFilter = IntentFilter()
                intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
                intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
                intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
                app.registerReceiver(netReceiver, intentFilter)
            }
        }
    }

}
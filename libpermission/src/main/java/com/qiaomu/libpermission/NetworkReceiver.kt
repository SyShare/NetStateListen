package com.qiaomu.libpermission

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

/**
 * Administrator create by 2019/12/26
 * not easy to coding
 * please don't modify at will!
 */
class NetworkReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (ConnectivityManager.CONNECTIVITY_ACTION != intent?.action) {
            return
        }
        val connectivityManager =
                AppCont.context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val netInfo = connectivityManager?.activeNetworkInfo
        NetStateHelper.dispatchNetStateList(netInfo?.isAvailable == true)
    }
}
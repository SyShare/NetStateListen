package com.qiaomu.permissionprocessor;

import android.app.Application;

import com.qiaomu.libpermission.AppCont;
import com.qiaomu.libpermission.NetManager;


/**
 * Administrator create by 2019/12/27
 * not easy to coding
 * please don't modify at will!
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCont.INSTANCE.setContext(this);
        NetManager.INSTANCE.registerNetChange(this);
    }
}

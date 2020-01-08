package com.qiaomu.permissionprocessor;

import android.app.Application;
import android.content.Context;

import com.qiaomu.libpermission.AppCont;
import com.qiaomu.libpermission.NetManager;


/**
 * Administrator create by 2019/12/27
 * not easy to coding
 * please don't modify at will!
 */
public class App extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        AppCont.INSTANCE.setContext(this);
        NetManager.INSTANCE.registerNetChange(this);
    }
}

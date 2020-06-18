object Versions {
    const val minSdkVersion = 18
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val buildToolsVersion = "28.0.3"

    const val supportVersion = "28.0.0"

    const val version_code = 85
    const val version_name = "3.10.10"

    internal const val kotlin = "1.3.71"
    internal const val android_gradle_plugin = "3.5.0"

    internal const val retrofit = "2.4.0"
    internal const val rxjava = "2.1.9"
    internal const val rxandroid = "2.1.1"
    internal const val okhttp = "3.9.0"

    internal const val constraint_layout = "1.1.3"
    internal const val jetpack_version = "1.1.1"

    internal const val jzvd_version = "1.0.1"
    internal const val switch_version = "1.0.0"
}

object MobSetting {
    const val appKey = "25ef8285d75ab"
    const val appSecret = "5ee863cfbd71a2edd06bb30d77b4e978"
    const val gui = false
    const val version = "3.7.2"

    object Wechat {
        const val sortId = 1
        const val appId = "wx07639c69c0192c57"
        const val appSecret = "9128cccbea655e783dbfa4690d1e3fb2"
    }

    object WechatMoments {
        const val sortId = 2
        const val appId = "wx07639c69c0192c57"
        const val appSecret = "9128cccbea655e783dbfa4690d1e3fb2"
    }

    object WechatFavorite {
        const val sortId = 3
        const val appId = "wx07639c69c0192c57"
        const val appSecret = "9128cccbea655e783dbfa4690d1e3fb2"
    }

    object QQ {
        const val sortId = 4
        const val appId = "1106087070"
        const val appSecret = "8kyiGY6p39qFCkTG"
        const val shareByAppClient  = true
    }

    object QZone {
        const val sortId = 4
        const val appId = "1106087070"
        const val appSecret = "8kyiGY6p39qFCkTG"
        const val shareByAppClient  = true
    }
}

object Deps {
    //kotlin
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val aspectjx_plugin = "com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.4"
    const val aspectjrt = "org.aspectj:aspectjrt:1.8.9"

    //ui
    const val app_compat_v7 = "com.android.support:appcompat-v7:${Versions.supportVersion}"
    const val support_v4 = "com.android.support:support-v4:${Versions.supportVersion}"
    const val design = "com.android.support:design:${Versions.supportVersion}"
    const val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.supportVersion}"
    const val card_view = "com.android.support:cardview-v7:${Versions.supportVersion}"
    const val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"
    const val support_annotations = "com.android.support:support-annotations:${Versions.supportVersion}"

    //网络
    const val okgo = "com.lzy.net:okgo:3.0.4"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid2 = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_log = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val rxjava1 = "io.reactivex:rxjava:1.1.6"
    const val rxandroid1 = "io.reactivex:rxandroid:1.2.1"


    //公共库
    const val lib_jzvd = "com.art.maven:lib-jzvd:${Versions.jzvd_version}"
    const val lib_switch = "com.art.maven:lib-switchenvirment:${Versions.switch_version}"
    const val lib_dialog = "com.art.maven:lib-dialog:${Versions.switch_version}"
    const val lib_imageLoader = "com.art.maven:lib-imageLoader:${Versions.switch_version}"
    const val lib_pullToRefresh = "com.art.maven:lib-pullToRefresh:${Versions.switch_version}"
    const val lib_permission = "com.art.maven:lib-permission:${Versions.switch_version}"
    const val lib_component = "com.art.maven:lib-component:1.0.1"
    const val countdown_view = "com.art.maven:lib-countdownview:1.0.0"

    //jetPack
    const val lifetime_runtime = "android.arch.lifecycle:runtime:${Versions.jetpack_version}"
    const val lifecycle_compiler = "android.arch.lifecycle:compiler:${Versions.jetpack_version}"
    const val lifecycle_common_java8 = "android.arch.lifecycle:common-java8:${Versions.jetpack_version}"
    const val lifecycle_xtensions = "android.arch.lifecycle:extensions:${Versions.jetpack_version}"
    const val core_testing = "android.arch.core:core-testing:${Versions.jetpack_version}"
    const val lifecycle_reactivestreams = "android.arch.lifecycle:reactivestreams:${Versions.jetpack_version}"


    //其他
    //gilde
    const val glide_transformations = "jp.wasabeef:glide-transformations:4.1.0"
    const val glide = "com.github.bumptech.glide:glide:4.8.0"
    const val glide_complier = "com.github.bumptech.glide:compiler:4.8.0"
    const val glide_okhttp3 = "com.github.bumptech.glide:okhttp3-integration:4.8.0"
    const val glide_annotations = "com.github.bumptech.glide:annotations:4.8.0"
    //immersionBar
    const val immersionbar = "com.gyf.immersionbar:immersionbar:3.0.0"
    //baseAdapter
    const val baseadapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:2.9.49"
    //multidex
    const val multidex = "com.android.support:multidex:1.0.3"
    //testUnit
    const val espresso_core = "com.android.support.test.espresso:espresso-core:2.2.2"
    const val testJunit = "junit:junit:4.12"
    const val test_runner = "com.android.support.test:runner:1.0.2"
    //bugly
    const val bugly = "com.tencent.bugly:crashreport:2.6.6"
    //eventBus
    const val eventbus = "org.greenrobot:eventbus:3.0.0"
    //gson
    const val gson = "com.google.code.gson:gson:2.8.5"
    //greendao
    const val greendao = "org.greenrobot:greendao-gradle-plugin:3.2.2"
    const val greendao_i = "org.greenrobot:greendao:3.2.2"
    const val greendao_helper = "com.github.yuweiguocn:GreenDaoUpgradeHelper:v2.1.0"
    //mobSdk 2020.0407.2207
    const val mobSdk = "com.mob.sdk:MobSDK:2018.0319.1724"
    //walle
    const val walle = "com.meituan.android.walle:plugin:1.1.6"
    //长图处理
    const val subsampling = "com.davemorrissey.labs:subsampling-scale-image-view:3.10.0"
    //微信支付
    const val wechat_pay = "com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+"
    //吸附
    const val pinnedSectionItemDecoration = "com.oushangfeng:PinnedSectionItemDecoration:1.3.2"
    //弹窗
    const val dialog_pop = "com.afollestad.material-dialogs:core:0.9.6.0"
    //photoView
    const val phote_view = "com.github.chrisbanes:PhotoView:2.1.3"
    //图库选择图片
    const val picker_view = "com.github.LuckSiege.PictureSelector:picture_library:v2.2.3"
    //滑动
    const val PickerView = "com.contrarywind:Android-PickerView:4.1.9"
    //刷新
    const val SmartRefreshLayout = "com.scwang.smartrefresh:SmartRefreshLayout:1.1.0"
    const val SmartRefreshLayout_header = "com.scwang.smartrefresh:SmartRefreshHeader:1.1.0"
    //banner
    const val banner = "com.youth.banner:banner:1.4.10"
    //圆角
    const val corner_view = "com.makeramen:roundedimageview:2.3.0"

    //butterknife
    const val butterknife = "com.jakewharton:butterknife:8.8.0"
    //butterknife_compiler
    const val butterknife_compiler = "com.jakewharton:butterknife-compiler:8.8.0"
    //fragment
    const val fragmentation = "me.yokeyword:fragmentation:1.3.7"
    //侧滑
    const val swipebacklayout = "me.imid.swipebacklayout.lib:library:1.1.0"
    //mqttv3
    const val mqttv3 = "org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.1.0"
    //流式布局
    const val flowlayout = "com.hyman:flowlayout-lib:1.1.2"
    //点赞
    const val simpleratingbar = "com.iarcuschin:simpleratingbar:0.1.5"
    //屏幕适配
    const val autosize = "me.jessyan:autosize:1.1.2"
    //utilcode
    const val utilcode = "com.blankj:utilcode:1.25.9"
    //图标库
    const val MPAndroidChart = "com.github.PhilJay:MPAndroidChart:v3.1.0"
    const val FlycoTabLayout_Lib = "com.flyco.tablayout:FlycoTabLayout_Lib:2.1.2@aar"
    const val ChipsLayoutManager = "com.beloo.widget:ChipsLayoutManager:0.3.7@aar"

    //极光
    const val jpush = "cn.jiguang.sdk:jpush:3.1.3"
    const val jpush_core = "cn.jiguang.sdk:jcore:1.2.1"

    //七牛
    const val qiniu_sdk = "com.qiniu:qiniu-android-sdk:7.3.15"

    //友盟
    const val umeng_analytics = "com.umeng.umsdk:analytics:8.1.6"
    const val umeng_common = "com.umeng.umsdk:common:2.2.5"

    //walle
    const val wall_library = "com.meituan.android.walle:library:1.1.6"
    //gif
    const val android_gif_drawable = "pl.droidsonroids.gif:android-gif-drawable:1.2.19"

    //arouter
    const val arouter = "com.alibaba:arouter-api:1.5.0"
    const val arouter_compiler = "com.alibaba:arouter-compiler:1.2.2"


    // 仅在debug包启用BlockCanary进行卡顿监控和提示的话
    const val debugblockcanary = "com.github.markzhai:blockcanary-android:1.5.0"
    const val releaseblockcanary = "com.github.markzhai:blockcanary-no-op:1.5.0"

    const val debugleakcanary = "com.squareup.leakcanary:leakcanary-android:1.5.4"
    const val releaseleakcanary = "com.squareup.leakcanary:leakcanary-android-no-op:1.5.4"

    //压缩图片
    const val McImage = "com.art.maven:lib-mc:1.0.0"
    //oss
    const val oss_android_sdk = "com.aliyun.dpa:oss-android-sdk:+"
    //日志库
    const val debug_net_capture = "com.art.maven:lib_debug:1.0.0"
    const val release_net_capture = "com.art.maven:lib_no_op:1.0.0"
}
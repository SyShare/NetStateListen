# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\mrs\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#-keep public class com.qiaomu.libpermission.**{*;}
#-keep public class com.qiaomu.annotation.**{*;}
#-keep public class com.qiaomu.compiler.**{*;}
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService

-dontwarn com.qiaomu.libpermission.**
-keep public class com.qiaomu.libpermission.** { *; }
# 不混淆使用了注解的类及类成员
-keep @com.qiaomu.libpermission.annotation.RegisterInjectEvent class * {*;}
-keep @com.qiaomu.annotation.NetChangeState class * {*;}

-keepclasseswithmembers class * {
    @com.qiaomu.annotation.NetChangeState <methods>;
}

#不混淆某个接口的实现
-keep class * implements com.qiaomu.libpermission.NetStateProxy { *; }

# aop注解
-adaptclassstrings
-keepattributes InnerClasses, EnclosingMethod, Signature, *Annotation*
-keepnames @org.aspectj.lang.annotation.Aspect class * {
    ajc* <methods>;
}
-keepclassmembers class ** {
    @com.qiaomu.libpermission.annotation.RegisterInjectEvent <methods>;
}
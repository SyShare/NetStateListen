package com.qiaomu.libpermission

import android.util.Log
import com.qiaomu.libpermission.annotation.RegisterInjectEvent
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

/**
 * Administrator create by 2019/12/30
 * not easy to coding
 * please don't modify at will!
 */
@Aspect
class RegisterAspectHelper {

    companion object {
        private val TAG: String = "RegisterHelper"
    }

    @Pointcut("execution(@com.qiaomu.libpermission.annotation.RegisterInjectEvent * *(..)) && @annotation(registerEvent)")
    fun methodAnnotatedWithRegisterEvent(registerEvent:RegisterInjectEvent) {
    }

    @Pointcut("execution(@com.qiaomu.libpermission.annotation.RegisterInjectEvent * *(..)) && @annotation(registerEvent)")
    fun methodAnnotatedWithUnRegisterEvent(registerEvent:RegisterInjectEvent) {
    }

    @After("methodAnnotatedWithRegisterEvent(registerEvent)")
    @Throws(Throwable::class)
    fun registerEventMethod(joinPoint: JoinPoint?,registerEvent:RegisterInjectEvent) {
        try {
            if (joinPoint == null || registerEvent.mode != NetMode.REGISTER_MODE) {
                return
            }
            NetStateHelper.registerObserver(joinPoint.target)
            Log.w(TAG, "registerObserver${joinPoint.target}")
        } catch (ignore: Exception) {
        }
    }

    @After("methodAnnotatedWithUnRegisterEvent(registerEvent)")
    @Throws(Throwable::class)
    fun unRegisterEventMethod(joinPoint: JoinPoint?,registerEvent:RegisterInjectEvent) {
        try {
            if (joinPoint == null || registerEvent.mode != NetMode.UN_REGISTER_MODE) {
                return
            }
            NetStateHelper.unRegisterObserver(joinPoint.target)
            Log.w(TAG, "unRegisterEventMethod${joinPoint.target}")
        } catch (ignore: Exception) {
        }
    }
}
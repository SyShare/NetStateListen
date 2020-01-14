package com.qiaomu.libpermission

import java.lang.ClassNotFoundException as ClassNotFoundException1

/**
 * Administrator create by 2019/12/27
 * not easy to coding
 * please don't modify at will!
 */

internal object NetStateHelper {

    private const val SUFFIX = "$\$NetStateProxy"

    private val dynamicProxy = DynamicProxy()
    private var dispatchMap: MutableMap<Any?, Any> = HashMap()

    private fun findNetStateProxy(activity: Any?): Any {
        try {
            val clazz: Class<*>? = activity?.javaClass
            val injectorClazz = Class.forName(clazz?.name + SUFFIX)
            return injectorClazz.newInstance()
        } catch (e: ClassNotFoundException1) {
            e.printStackTrace()
        }
        throw RuntimeException(String.format("can not find %s , something when compiler.", activity?.javaClass?.simpleName + SUFFIX))
    }

    /**
     * 分发
     */
    internal fun dispatchNetStateList(isAvailable: Boolean) {
        if (dispatchMap.isEmpty()) {
            return
        }
        for ((key, value) in dispatchMap) {
            val proxyInterObj = dynamicProxy.newProxyInstance(value)
            if (proxyInterObj is NetStateProxy?) {
                proxyInterObj?.onNetChange(key, isAvailable)
            }
        }
    }


    internal fun unRegisterObserver(register: Any?) {
        if (!dispatchMap.isEmpty() && dispatchMap.containsKey(register)) {
            dispatchMap.remove(register)
        }
    }

    internal   fun registerObserver(register: Any?) {
        var classProxyImpl = dispatchMap[register]
        if (classProxyImpl == null) {
            classProxyImpl = findNetStateProxy(register)
            dispatchMap.put(register, classProxyImpl)
        }
    }
}
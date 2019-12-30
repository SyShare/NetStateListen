 package com.qiaomu.libpermission

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * Administrator create by 2019/12/27
 * not easy to coding
 * please don't modify at will!
 */
 internal class DynamicProxy : InvocationHandler {

    private var proxyObject: Any? = null

    fun newProxyInstance(proxyObject: Any?): Any? {
        this.proxyObject = proxyObject
        return Proxy.newProxyInstance(proxyObject?.javaClass?.classLoader,
                proxyObject?.javaClass?.interfaces, this)
    }

    override fun invoke(p0: Any?, method: Method?, args: Array<out Any>?): Any? {
        return method?.invoke(proxyObject, *(args ?: arrayOfNulls<Any>(0)))
    }
}
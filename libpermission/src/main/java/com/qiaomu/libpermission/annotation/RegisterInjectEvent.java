package com.qiaomu.libpermission.annotation;

import com.qiaomu.libpermission.NetMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author by Administrator , Date on 2019/3/7.
 * PS: Not easy to write code, please indicate.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterInjectEvent {

    NetMode mode() default NetMode.REGISTER_MODE;
}

package com.zjut.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月21日 下午2:06:40
 */
@Target({ ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

	public String operationType() default "";

	public String operationName() default "";

}

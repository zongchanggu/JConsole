package com.zjut.aop;

import java.lang.reflect.Method;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zjut.annotion.Log;
import com.zjut.pojo.User;
import com.zjut.pojo.UserDevLog;
import com.zjut.service.UserDevLogService;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月21日 下午2:08:11
 */
@Aspect
public class LogAspect {

	private Logger logger = Logger.getLogger(LogAspect.class);

	@Resource
	private UserDevLogService userDevLogImpl;

	@Pointcut("execution(* com.zjut.controller.DeviceAction.*(..))")
	public void controllerAspect() {
	}

	@Before("controllerAspect()")
	public void doBefore(JoinPoint jp) {
		logger.info("start to execute before advice .....");
		if (logger.isInfoEnabled())
			logger.info("before " + jp);
	}

	@After("controllerAspect()")
	public void doAfter(JoinPoint jp) {
		logger.info("start to execute after advice...");
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes()))
				.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
 		String methodName = jp.getSignature().getName();
		Object[] params = jp.getArgs();
		String operationType = null;
		String operationName = null;
		Method[] methods = jp.getTarget().getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazz = method.getParameterTypes();
				if (clazz.length == params.length) {
					operationType = method.getAnnotation(Log.class).operationType();
					operationName = method.getAnnotation(Log.class).operationName();
					break;
				}
			}
		}
		UserDevLog udl = new UserDevLog();
		udl.setUserID(user.getUserID());
		udl.setUserName(user.getUserName());
		udl.setOperationName(operationName);
		udl.setOperationType(operationType);
		userDevLogImpl.insertOperateName(udl);
	}

	@AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint jp, Throwable e) {
		logger.info(jp.getTarget().getClass().getName() + "," + jp.getSignature().getName() + "," + e.getMessage());
	}

	@AfterReturning(pointcut = "controllerAspect()")
	public void doAfterReturing(JoinPoint jp) {
		logger.info("start to execute after returing advice");
		if (logger.isInfoEnabled())
			logger.info("after returning" + jp);
	}

	@Around("controllerAspect()")
	public void doAround(JoinPoint jp) {
		logger.info("start to execute around advice....");
		long start = System.currentTimeMillis();
		try {
			((ProceedingJoinPoint) jp).proceed();
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled())
				logger.info("around " + jp + "use time " + (end - start) + " ms!");
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled())
				logger.info("around " + jp + " use time " + (end - start) + " ms with exception " + e.getMessage());
		}

	}
}

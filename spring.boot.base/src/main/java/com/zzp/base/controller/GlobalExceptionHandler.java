package com.zzp.base.controller;

import com.zzp.base.exceptions.FeignApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 全局异常处理handler
 * @Author Garyzeng
 * @since 2019.06.10
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = FeignApiException.class)
    @ResponseBody
    public void handleBadRequest(HttpServletRequest request, HttpServletResponse response, FeignApiException e) {
        e.printStackTrace();
        throw e;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object handleBadRequest(HttpServletRequest request, HttpServletResponse response, RuntimeException e) {
        e.printStackTrace();
        return "运行时异常";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleBadRequest(HttpServletRequest request, HttpServletResponse response, Exception e) {

		/*
		 * 业务逻辑异常
		 */
        if (e instanceof NullPointerException) {
            return "空指针异常";
        }

        /**
         * 系统内部异常，打印异常栈
         */
        logger.error("Error: handle System Exception StackTrace : ", e);

        return "系统异常";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Controller中使用了@RequestParam注解的String类型参数，如果传入的是空字符串""，则会将其转换为null
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}

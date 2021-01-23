package com.zzp.base.controller;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.base.exceptions.FeignApiException;
import com.zzp.base.results.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 全局异常处理handler
 * @Author Garyzeng
 * @since 2019.06.10
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

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

    /**
     * 处理校验异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Object MethodArgumentNotValidHandler(HttpServletRequest request, HttpServletResponse response,
                                                MethodArgumentNotValidException e) throws Exception {

        // 按需重新封装需要返回的错误信息
        StringBuilder message = new StringBuilder();
        List<String> messageList = new ArrayList<>();
        // 解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : e.getBindingResult().getFieldErrors()) {

            String key = error.getDefaultMessage().replace("{", "").replace("}", "");

            // error.getField()
            try {
                message.append(messageSource.getMessage(key, getMessageArgs(error), request.getLocale())).append(",");
                messageList.add(messageSource.getMessage(key, getMessageArgs(error), request.getLocale()));
            } catch (NoSuchMessageException nse) {
                message.append(error.getDefaultMessage()).append(",");
                messageList.add(error.getDefaultMessage());
            }
        }

        if (message.length() > 0) {
            message.deleteCharAt(message.lastIndexOf(","));

            return Result.failed(message.toString());
        } else {
//			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//			response.setContentType("application/json;charset=UTF-8");

            logger.error("Error: handle [Valid Exception] StackTrace", e);
        }

        return Result.failed("系统异常，请联系管理员");
    }

    private Object[] getMessageArgs(FieldError error) {
        if (error != null && error.getArguments().length > 1) {
            Object[] rtn = new Object[error.getArguments().length-1];

            for (int i = 0; i < error.getArguments().length-1; i++) {
                rtn[i] = error.getArguments()[error.getArguments().length-1-i];
            }

            return rtn;
        }

        return new Object[]{};
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public Object handleApiException(HttpServletRequest request, HttpServletResponse response, ApiException e) {
        return Result.failed(e.getMessage());
    }

}

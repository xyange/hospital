package com.wyzy.hospital.coupon.exception;


import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * @Function:
 * @Author: aqie
 * @Date: 2019/4/20 14:31
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value=Exception.class)        // 拦截所有异常
    public R<String> exceptionHandler(HttpServletRequest request, Exception e){
        // log.error("ERROR",  e);
        if(e instanceof GlobalException) {
            GlobalException ex = (GlobalException)e;
            return R.error(ex.getCm());
        // 缺少参数
        } else if(e instanceof MissingServletRequestPartException | e instanceof MissingServletRequestParameterException | e instanceof MethodArgumentTypeMismatchException){
            return R.failed(e.getMessage());
        }else if(e instanceof HttpMessageNotReadableException){
            return R.error(CodeMsg.NO_REQUEST_BODY_ERROR );
        } else if(e instanceof SQLIntegrityConstraintViolationException) {
            return R.failed(e.getMessage());
        }else if(e instanceof CommunicationsException){             // 数据库连接异常
            return R.error(CodeMsg.MYSQL_CONNECT_ERROR);
        }else if(e instanceof DataAccessResourceFailureException){  // 客户端未检测到服务端连接释放
            return R.error(CodeMsg.MYSQL_DATA_ACCESS_RESOURCE_FAILURE_ERROR);
        }else if(e instanceof BindException) {      // 普通 参数 校验失败 validate
            BindException ex = (BindException)e;
            List<ObjectError> errors = ex.getAllErrors();
            StringBuilder err = new StringBuilder();
            for(ObjectError error : errors) {
                err.append(error.getDefaultMessage()).append(" ");
            }
            return R.error(CodeMsg.PARAMETER_ERROR.fillArgs(err));
        }else if(e instanceof MethodArgumentNotValidException){ // requestBody validate 校验失败
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;

            BindingResult bindingResult = ex.getBindingResult();

            StringBuilder errorMessage = new StringBuilder("校验失败:");

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append(", ");
            }

            return R.error(CodeMsg.PARAMETER_ERROR.fillArgs(errorMessage));
        }else if(e instanceof HttpMediaTypeException){
            return R.error(CodeMsg.MEDIA_TYPE_NOT_ACCEPT_ERROR);
        } else if(e instanceof  NullPointerException){
            log.error("ERROR",  e);
            return R.failed("NullPointerException");
        }
        else if(e instanceof NoHandlerFoundException){
            return R.error(new CodeMsg(HttpStatus.NOT_FOUND.value(),e.getMessage()));
        }else if(e instanceof HttpRequestMethodNotSupportedException){
            return R.failed(e.getMessage());
        }
        else {
            log.error("ERROR",  e);
            return R.error(new CodeMsg(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
        }
    }
}

package com.lzq.dispose_exception.exception;

import com.lzq.dispose_exception.vo.BaseResult;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author lzq
 * @version 1.0
 * @date 2020/12/18 9:49
 */
@ControllerAdvice
@ResponseBody
public class HttpErrorController{

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public BaseResult runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(500, ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public BaseResult nullPointerExceptionHandler(NullPointerException ex) {
        System.err.println("NullPointerException:");
        return resultFormat(500, ex);
    }


    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public BaseResult classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(500, ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public BaseResult iOExceptionHandler(IOException ex) {
        return resultFormat(500, ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public BaseResult noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(500, ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public BaseResult indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(500, ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public BaseResult requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(500, ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public BaseResult requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(500, ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public BaseResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(500, ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public BaseResult request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(500, ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public BaseResult request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return resultFormat(500, ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public BaseResult server500(RuntimeException ex) {
        System.out.println("500...");
        return resultFormat(500, ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public BaseResult requestStackOverflow(StackOverflowError ex) {
        return resultFormat(500, ex);
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public BaseResult arithmeticException(ArithmeticException ex) {
        return resultFormat(500, ex);
    }


    //其他错误
    @ExceptionHandler({Exception.class})
    public BaseResult exception(Exception ex) {
        return resultFormat(500, ex);
    }
    private <T extends Throwable> BaseResult resultFormat(Integer code, T ex) {
        ex.printStackTrace();
        return new BaseResult(code, ex.getMessage());
    }

}
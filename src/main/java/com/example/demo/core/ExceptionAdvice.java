package com.example.demo.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by whydd on 2017-07-13.
 */
@ControllerAdvice
public class ExceptionAdvice {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception e) throws Exception {
        LOGGER.error(e.getMessage(), e, e.getStackTrace());
        return new HashMap<>();
    }

    @ExceptionHandler(ApiException.class)
    public Map<String, Object> handleApiException(ApiException ae) throws Exception {
        LOGGER.error(ae.getMessage(), ae, ae.getStackTrace());
        return new HashMap<>();
    }

    @ExceptionHandler(AuthException.class)
    public Map<String, Object> handleApiException(AuthException ae) throws Exception {
        LOGGER.error(ae.getMessage(), ae, ae.getStackTrace());
        return new HashMap<>();
    }
}

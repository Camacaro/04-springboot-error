package com.jesus.courses.springboot.error.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;


@RestControllerAdvice
public class ErrorRestHandlerController {

    /*
        Para manejar peticiones 404 sin que utilice la vista 404.html
        se usa de este modo.

        y En la properties hay que agregar la siguiente configuración

        spring.mvc.throw-exception-if-no-handler-found=true
        server.error.whitelabel.enabled=false
        spring.web.resources.add-mappings=false
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "fail");
        response.put("message", e.getLocalizedMessage());
        return response;
    }
}

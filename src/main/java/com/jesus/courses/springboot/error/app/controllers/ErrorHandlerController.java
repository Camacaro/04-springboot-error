package com.jesus.courses.springboot.error.app.controllers;

import com.jesus.courses.springboot.error.app.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    // para varias usar {ArithmeticException.class, }
    @ExceptionHandler(ArithmeticException.class)
    public String aritmeticaError(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/aritmetica";
    }


    @ExceptionHandler(NumberFormatException.class)
    public String conversionError(NumberFormatException ex, Model model) {
        model.addAttribute("error", "Formato número inválido");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/conversion";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException ex, Model model) {
        model.addAttribute("error", "Usuario no encontrado");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        model.addAttribute("Exception", "UserNotFoundException");
        return "error/generic";
    }
}

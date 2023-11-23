package com.jesus.courses.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/index")
    public String index() {
        /*
          A propósito no se creó la plantilla "index" para que arroje el error 500
          por no encontrar la plantilla. En los templates se creó el directorio
          "error" el cual por convención de Spring boot va a buscar el código del
          error y mostrará esa plantilla un error 500 muestra el 500.html
         */
        return "index";
    }

    @GetMapping("/aritmetica")
    public String aritmetica() {

        /*
         Este es un error a propósito para captura el error ArithmeticException
         y devolver un error personalizado que se encuentra en ErrorHandlerController
         */
        int value = 100 / 0;

        return "index";
    }

    @GetMapping("/conversion")
    public String conversion() {

        /*
         Este es un error a propósito para captura el error NumberFormatException
         y devolver un error personalizado que se encuentra en ErrorHandlerController
         */
        Integer value = Integer.parseInt("10x");

        return "index";
    }
}

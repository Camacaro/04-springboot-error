package com.jesus.courses.springboot.error.app.controllers;

import com.jesus.courses.springboot.error.app.errors.UserNotFoundException;
import com.jesus.courses.springboot.error.app.models.domain.User;
import com.jesus.courses.springboot.error.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    private final UserService userService;

    /*
    Como solo hay un UserService implementandolo no le voy agregar
    el @Qualifier
     */
    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

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

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        User user = userService.userById(id);
        if (user == null) {
            /*
            Creamos un error custom para los usuarios que no se encuentren.
            Al ejecutarse atajamos el UserNotFoundException en ErrorHandlerController
            y desviamos a una vista personalizada.
             */
            throw new UserNotFoundException(id.toString());
        }
        model.addAttribute("user", user);
        model.addAttribute("title", "Detalle usuario: ".concat(user.getName()));
        return "show";
    }
}

package com.jesus.courses.springboot.error.app.controllers;

import com.jesus.courses.springboot.error.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppRestController {

    private final UserService userService;

    @Autowired
    public AppRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> json = new HashMap<>();
        json.put("ok", true);
        json.put("message", "Solicitud procesada correctamente");
        return json;
    }
}

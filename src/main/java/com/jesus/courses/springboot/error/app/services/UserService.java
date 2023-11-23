package com.jesus.courses.springboot.error.app.services;

import com.jesus.courses.springboot.error.app.models.domain.User;

import java.util.List;

public interface UserService {

    public List<User> list();

    public User userById(Integer id);
}

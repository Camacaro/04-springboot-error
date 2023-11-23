package com.jesus.courses.springboot.error.app.services;

import com.jesus.courses.springboot.error.app.models.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplement implements UserService {

    private final List<User> list;

    public UserServiceImplement() {
        this.list = new ArrayList<>();

        User user1 = new User(1, "Jesus", "Camacaro");
        User user2 = new User(2, "Pepe", "García");
        User user3 = new User(3, "Lalo", "Mena");
        User user4 = new User(4, "Luci", "Fernández");
        User user5 = new User(5, "Pato", "González");
        User user6 = new User(6, "Paco", "Rodríguez");
        User user7 = new User(7, "Juans", "Gómez");

        this.list.add(user1);
        this.list.add(user2);
        this.list.add(user3);
        this.list.add(user4);
        this.list.add(user5);
        this.list.add(user6);
        this.list.add(user7);
    }

    @Override
    public List<User> list() {
        return this.list;
    }

    @Override
    public User userById(Integer id) {
        User result = null;

        for (User u: list) {
            if(u.getId().equals(id)) {
                result = u;
                break;
            }
        }

        return result;
    }
}

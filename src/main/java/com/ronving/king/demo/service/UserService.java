package com.ronving.king.demo.service;

import com.ronving.king.demo.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> findAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    boolean deleteUser(User user);
}

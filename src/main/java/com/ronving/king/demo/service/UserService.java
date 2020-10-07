package com.ronving.king.demo.service;

import com.ronving.king.demo.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    User addNew(User user);
    User update(User user);
    boolean delete(Long id);
}

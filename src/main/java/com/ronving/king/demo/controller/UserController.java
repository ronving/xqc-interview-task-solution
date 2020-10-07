package com.ronving.king.demo.controller;

import com.ronving.king.demo.entity.User;
import com.ronving.king.demo.service.UserService;
import com.ronving.king.demo.util.Response;
import com.ronving.king.demo.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    Response<List<User>> getFullUserList() {
        List<User> users = userService.findAll();
        if (users == null) {
            return new Response<>(Status.FAIL, "users not found");
        }
        return new Response<>(Status.SUCCESS, users, "users found");
    }

    @GetMapping("/{id}")
    Response<User> getUser(@PathVariable Long id) {
        User userResponse = userService.findById(id);
        if (userResponse == null) {
            return new Response<>(Status.FAIL, "user not found");
        }
        return new Response<>(Status.SUCCESS, userResponse, "user found");
    }

    @PostMapping
    Response<User> addNewUser(@RequestBody User user) {
        User userResponse = userService.addNew(user);
        if (userResponse == null) {
            return new Response<>(Status.FAIL, "user already exist");
        }
        return new Response<>(Status.SUCCESS, userResponse, "user created");
    }

    @PutMapping("/{id}")
    Response<User> updateUser(@PathVariable Long id) {
        User user = userService.findById(id);
        User userResponse = userService.update(user);
        if (userResponse == null) {
            return new Response<>(Status.BAD_REQUEST, "user doesn't exist");
        }
        return new Response<>(Status.SUCCESS, userResponse, "user updated successfully");
    }

    @DeleteMapping("/{id}")
    Response deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.delete(id);
        if (isDeleted) {
            return new Response(Status.SUCCESS, "user deleted successfully");
        }
        return new Response(Status.BAD_REQUEST, "something went wrong");
    }
}

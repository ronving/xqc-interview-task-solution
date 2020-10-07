package com.ronving.king.demo.repository;

import com.ronving.king.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findUserById(Long id);
}


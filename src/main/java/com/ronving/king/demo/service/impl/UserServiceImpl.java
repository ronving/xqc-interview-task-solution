package com.ronving.king.demo.service.impl;

import com.ronving.king.demo.entity.User;
import com.ronving.king.demo.repository.UserRepo;
import com.ronving.king.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> fullUserList = userRepository.findAll();
        return fullUserList;
    }

    @Override
    public User addNew(User user) {
        User alreadyExists = userRepository.findByUsername(user.getUsername());

        if (alreadyExists == null) {
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User update(Long id, User user) {
        User userFromDb = userRepository.findUserById(id);
        if (userFromDb != null) {
            userFromDb.setUsername(user.getUsername());
            userFromDb.setPassword(user.getPassword());
            return userRepository.save(userFromDb);
        }

        return null;
    }

    @Override
    public boolean delete(Long id) {
        userRepository.deleteById(id);

        if (userRepository.findUserById(id) == null) {
            return true;
        }
        return false;
    }
}

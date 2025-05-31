package org.example.springBootCrud.service;

import org.example.springBootCrud.model.User;
import org.example.springBootCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveuser(User user) {
        return userRepository.save(user);
    }

    public User updateById(UUID id){
        return userRepository.getOne(id);
    }

    public void deleteById(UUID id){
        userRepository.deleteById(id);
    }
}
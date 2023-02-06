package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserModel usuario){
        return userRepository.save(usuario);
    }

    public List<UserModel> getUsers(){
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}

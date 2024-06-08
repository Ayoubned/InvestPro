package com.example.investpro.Service;

import com.example.investpro.Module.User;
import com.example.investpro.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

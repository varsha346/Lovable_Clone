package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
import com.lovable.demo.Service.UserService;
import com.lovable.demo.entity.User;
import com.lovable.demo.error.ResourceNotFoundException;
import com.lovable.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Override
    public UserProfileResponse getProfile(long userId) {
        return null;
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }
    public User getUserByUsername(String email){
        return userRepository.findByUsername(email).orElse(null);
    }
    public User save(User newuser){
        return userRepository.save(newuser);
    }

}

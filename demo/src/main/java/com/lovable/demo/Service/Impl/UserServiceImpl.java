package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
import com.lovable.demo.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileResponse getProfile(long userId) {
        return null;
    }
}

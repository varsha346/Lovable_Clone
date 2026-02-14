package com.lovable.demo.Service;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
//import org.jspecify.annotations.Nullable;
import com.lovable.demo.entity.User;

import java.util.Optional;


public interface UserService {
     UserProfileResponse getProfile(long userId);

    User getUserById(Long userId);

    User getUserByUsername(String email);
    User save(User user);
}

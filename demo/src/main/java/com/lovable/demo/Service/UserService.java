package com.lovable.demo.Service;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;


public interface UserService {
     UserProfileResponse getProfile(long userId);
}

package com.lovable.demo.Service;

import com.lovable.demo.Dto.Auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;

public interface UserService {
     UserProfileResponse getProfile(long userId);
}

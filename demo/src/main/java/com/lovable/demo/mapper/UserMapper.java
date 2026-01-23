package com.lovable.demo.mapper;

import com.lovable.demo.Dto.Auth.SignupRequest;
import com.lovable.demo.Dto.Auth.UserProfileResponse;
import com.lovable.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
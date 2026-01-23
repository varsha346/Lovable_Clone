package com.lovable.demo.mapper;

import com.lovable.demo.Dto.Auth.SignupRequest;
import com.lovable.demo.Dto.Auth.UserProfileResponse;
import com.lovable.demo.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-23T14:52:09+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(SignupRequest signupRequest) {
        if ( signupRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( signupRequest.username() );
        user.password( signupRequest.password() );
        user.name( signupRequest.name() );

        return user.build();
    }

    @Override
    public UserProfileResponse toUserProfileResponse(User user) {
        if ( user == null ) {
            return null;
        }

        long id = 0L;
        String name = null;
        String avatarUrl = null;

        if ( user.getId() != null ) {
            id = user.getId();
        }
        name = user.getName();
        avatarUrl = user.getAvatarUrl();

        String email = null;

        UserProfileResponse userProfileResponse = new UserProfileResponse( id, email, name, avatarUrl );

        return userProfileResponse;
    }
}

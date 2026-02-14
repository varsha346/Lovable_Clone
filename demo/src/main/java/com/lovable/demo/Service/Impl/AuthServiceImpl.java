package com.lovable.demo.Service.Impl;

import com.lovable.demo.Dto.Auth.AuthResponse;
import com.lovable.demo.Dto.Auth.LoginRequest;
import com.lovable.demo.Dto.Auth.SignupRequest;
import com.lovable.demo.Security.AuthUtil;
import com.lovable.demo.Service.AuthService;
import com.lovable.demo.Service.UserService;
import com.lovable.demo.entity.User;
import com.lovable.demo.error.BadRequestException;
import com.lovable.demo.mapper.UserMapper;
import com.lovable.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    UserMapper userMapper;
    UserService userService;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;
    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(
                user->{
                    throw new BadRequestException("user already exists with username:"+request.username());
                }
        );
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        String token = authUtil.generateAccessToken(user);
        String refreshToken = authUtil.generateRefreshToken(user);
        return new AuthResponse(token,refreshToken,userMapper.toUserProfileResponse(user));

    }

    @Override
    public AuthResponse login(LoginRequest request) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.username(), request.password())
//        );
//        UserDetails userDetails =
//                (UserDetails) authentication.getPrincipal();

//        User user = (User) authentication.getPrincipal();
        User user = userRepository
                .findByUsername(request.username())
                .orElseThrow();

        String token = authUtil.generateAccessToken(user);
        String refreshToken = authUtil.generateRefreshToken(user);
        return new AuthResponse(token,refreshToken, userMapper.toUserProfileResponse(user));
    }

    @Override
   public AuthResponse refreshToken(String refreshToken){
         Long userId = authUtil.getUserIdFromToken(refreshToken);
         User user = userService.getUserById(userId);

         String accessToken = authUtil.generateAccessToken(user);
         return new AuthResponse(accessToken,refreshToken,userMapper.toUserProfileResponse(user));


    }

}


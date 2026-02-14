package com.lovable.demo.Controller;
import com.lovable.demo.Dto.Auth.*;
import com.lovable.demo.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;
import com.lovable.demo.Service.AuthService;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class AuthController {

 AuthService authservice;
 UserService userservice;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authservice.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req, HttpServletRequest request, HttpServletResponse response){

        AuthResponse authResponse = authservice.login(req);
        Cookie cookie = new Cookie("refreshToken", authResponse.token());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(authResponse);
    }


    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse>refresh(HttpServletRequest request){
      String refreshToken =  Arrays.stream(request.getCookies())
                .filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found inside the Cookies"));

        AuthResponse authResponse = authservice.refreshToken(refreshToken);
         return ResponseEntity.ok(authResponse);

    }





  @GetMapping("/me")
  public ResponseEntity<UserProfileResponse>getProfile(){
        long userId = 1L;
      return ResponseEntity.ok(userservice.getProfile(userId));
  }

}

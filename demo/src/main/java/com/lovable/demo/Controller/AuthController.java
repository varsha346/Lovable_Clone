package com.lovable.demo.Controller;
import com.lovable.demo.Dto.Auth.*;
import com.lovable.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lovable.demo.Service.AuthService;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

private AuthService authservice;
private UserService userservice;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest request) {
        return ResponseEntity.ok(authservice.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authservice.login(request));
    }




  @GetMapping("/me")
  public ResponseEntity<UserProfileResponse>getProfile(){
        long userId = 1L;
      return ResponseEntity.ok(userservice.getProfile(userId));
  }

}

package com.lovable.demo.Controller;
import com.lovable.demo.Dto.Auth.*;
import com.lovable.demo.Service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lovable.demo.Service.AuthService;

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
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authservice.login(request));
    }




  @GetMapping("/me")
  public ResponseEntity<UserProfileResponse>getProfile(){
        long userId = 1L;
      return ResponseEntity.ok(userservice.getProfile(userId));
  }

}

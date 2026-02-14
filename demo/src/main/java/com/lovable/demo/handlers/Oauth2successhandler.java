package com.lovable.demo.handlers;

import com.lovable.demo.Security.AuthUtil;
import com.lovable.demo.Service.UserService;
import com.lovable.demo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor

@Slf4j
public class Oauth2successhandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserService userService;
    private final AuthUtil authUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) token.getPrincipal();
        String email = oAuth2User.getAttribute("email");
//        log.info(oAuth2User.getAttribute("email"));
        User user = userService.getUserByUsername(email);
        if(user==null){
            User newuser = User.builder()
                    .name(oAuth2User.getAttribute("name"))
                    .username(email)
                    .build();

            user = userService.save(user);
        }
        String accessToken = authUtil.generateAccessToken(user);
        String refreshToken = authUtil.generateRefreshToken(user);

        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);


        String frontendUrl = "http://localhost:8080/home.html?token="+accessToken;
        getRedirectStrategy().sendRedirect(request,response,frontendUrl);



    }


}

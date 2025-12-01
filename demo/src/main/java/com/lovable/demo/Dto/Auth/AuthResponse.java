package com.lovable.demo.Dto.Auth;
//record used for - need not to cretae the private attributes , no need to make getters setteres .. it take care of it
public record AuthResponse(String token,
                           UserProfileResponse user) {

}

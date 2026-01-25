package com.lovable.demo.Security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtAuditorAware implements AuditorAware<Long> {

    private final AuthUtil authUtil;

    public JwtAuditorAware(AuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        try {
            return Optional.of(authUtil.getCurrentUserId());
        } catch (AuthenticationCredentialsNotFoundException ex) {
            // for public endpoints, scheduler, startup
            return Optional.empty();
        }
    }
}



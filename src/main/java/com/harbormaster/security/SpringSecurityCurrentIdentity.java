package com.harbormaster.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityCurrentIdentity
        implements CurrentIdentity {

    protected Authentication authentication() {

        return SecurityContextHolder
                .getContext()
                .getAuthentication();
    }

    @Override
    public boolean isAuthenticated() {

        Authentication authentication =
                authentication();

        return authentication != null &&
                authentication.isAuthenticated();
    }

    @Override
    public String getSubject() {

        Authentication authentication =
                authentication();

        if (authentication instanceof JwtAuthenticationToken jwt) {

            return jwt.getToken().getSubject();
        }

        return authentication.getName();
    }

    @Override
    public String getUsername() {

        return getSubject();
    }

    @Override
    public String getOrganizationId() {

        Authentication authentication =
                authentication();

        if (authentication instanceof JwtAuthenticationToken jwt) {

            return jwt.getToken()
                    .getClaimAsString("organization");
        }

        return null;
    }

    @Override
    public Collection<String> getAuthorities() {

        return authentication()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasAuthority(
            String authority) {

        return authentication()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(authority::equals);
    }

}
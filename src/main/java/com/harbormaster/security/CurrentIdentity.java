package com.harbormaster.security;

import java.util.Collection;

public interface CurrentIdentity {

    boolean isAuthenticated();

    String getSubject();

    String getUsername();

    String getOrganizationId();

    Collection<String> getAuthorities();

    boolean hasAuthority(String authority);


}
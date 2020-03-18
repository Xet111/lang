package com.ua.lang.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleType implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();

    }
}

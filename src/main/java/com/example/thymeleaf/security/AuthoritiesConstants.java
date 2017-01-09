package com.example.thymeleaf.security;

/**
 * Constants for Spring Security authorities.
 *
 * @author Serdar Turkmen
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}

package com.dungken.scientificresearch2024backend.security;

public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    /////////////// PUBLIC ///////////////
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/account/active",
            "/account/reset-pass",
            "/user/search/existsByUsername",
            "/user/search/existsByEmail",
    };

    public static final String[] PUBLIC_PUT_ENDPOINS = {
            "/user",
            "/account/reset-password",
            "/account/update-password"
    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/account/register",
            "/account/reset-password",
            "/account/login",

    };

//    public static final String[] PUBLIC_DELETE_ENDPOINS = {
//
//    };

    /////////////// ADMIN ///////////////
    public static final String[] ADMIN_GET_ENDPOINS = {
            "/role",
            "/role/**",
            "/user",
            "/user/**",
            "/user/search/findByUsernameContaining/**",
            "/permission",
            "/permission/**",
    };
    public static final String[] ADMIN_POST_ENDPOINS = {
            "/api/user/add",
            "/account/register",
            "/user/**",
            "/user",
            "/account/login",
            "/permission",
            "/permission/**",
            "/role/add",
            "/role/**",
    };
    public static final String[] ADMIN_PUT_ENDPOINS = {
            "/api/user/update",
            "/permission",
            "/permission/**",
            "/user/**",
            "/account/update",
            "/role",
            "/role/**",
            "/role/update",
    };
    public static final String[] ADMIN_DELETE_ENDPOINS = {
            "/user/**",
            "/permission/**",
            "/role",
            "/role/**"
    };
}
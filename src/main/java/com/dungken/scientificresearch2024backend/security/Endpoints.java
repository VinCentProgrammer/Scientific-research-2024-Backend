package com.dungken.scientificresearch2024backend.security;

public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    /////////////// PUBLIC ///////////////
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/account/active",
            "/account/reset-pass"
    };

    public static final String[] PUBLIC_PUT_ENDPOINS = {
            "/account/reset-password",
            "/account/update-password"
    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/account/register",
            "/account/reset-password",
            "account/login"
    };

//    public static final String[] PUBLIC_DELETE_ENDPOINS = {
//
//    };

    /////////////// ADMIN ///////////////
    public static final String[] ADMIN_GET_ENDPOINS = {
            "/user",
            "/user/**",
    };
    public static final String[] ADMIN_POST_ENDPOINS = {
            "user/add",
            "account/login"
    };
//    public static final String[] ADMIN_PUT_ENDPOINS = {
//
//    };
//    public static final String[] ADMIN_DELETE_ENDPOINS = {
//
//    };
}
package com.dungken.scientificresearch2024backend.security;

public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    public static final String[] PUBLIC_GET_ENDPOINS = {

    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/account/register",
            "/account/login",
    };

    public static final String[] ADMIN_GET_ENDPOINS = {
            "/user",
            "/user/**",
    };
    public static final String[] ADMIN_POST_ENDPOINS = {

    };
}
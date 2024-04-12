package com.dungken.scientificresearch2024backend.security;

public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    /////////////// PUBLIC ///////////////
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/account/active",
            "/account/reset-pass",
            "/user/search/existsByUsername",
            "/user/search/existsByEmail",
            "/post-detail",
            "/post-detail/**",
            "/theory-detail",
            "/api/theory/cat/**",
            "/theory-detail/**",

            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",
            "/theory-keyword/search/findTheoryDetailByKeywordEqualsIgnoreCase/**",
            "/api/theory/keyword/search/**",
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
            "/post-cat",
            "/post-cat/**",
            "/post-detail",
            "/post-detail/**",
            "/theory-detail",
            "/theory-detail/**",
            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",
            "/api/theory/cat/**",
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
            "/post-cat",
            "/post-cat/**",
            "/api/post/add",
            "/api/theory/add",
            "/api/theory/cat/add",
            "/api/theory/example/add",
            "/api/theory/keyword/add",

            "/theory-detail",
            "/theory-detail/**",
            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",
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
            "/post-cat",
            "/post-cat/**",
            "/api/post",
            "/api/post/**",
            "/api/post/update",
            "/api/theory/update",
            "/api/theory/cat/update",
            "/api/theory/example/update",
            "/api/theory/keyword/update",

            "/theory-detail",
            "/theory-detail/**",
            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",
    };
    public static final String[] ADMIN_DELETE_ENDPOINS = {
            "/user/**",
            "/permission/**",
            "/role",
            "/role/**",
            "/post-cat",
            "/post-cat/**",
            "/post-detail",
            "/post-detail/**",
            "/theory-detail",
            "/theory-detail/**",
            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",
    };
}
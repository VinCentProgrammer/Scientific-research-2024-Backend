package com.dungken.scientificresearch2024backend.security;

public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";
    /////////////// PUBLIC ///////////////
    public static final String[] PUBLIC_GET_ENDPOINS = {

            "user/",
            "user/**",

            "/account/active",
            "/account/reset-pass",
            "/user/search/existsByUsername",
            "/user/search/existsByEmail",

            "/post-detail",
            "/post-detail/**",

            "/post-cat",
            "/post-cat/**",

            "/page",
            "/page/**",

            "/thread",
            "/thread/**",

            "/thread-cat",
            "/thread-cat/**",

            "/thread-comment",
            "/thread-comment/**",

            "/thread-image",
            "/thread-image/**",

            "/theory-detail",
            "/api/theory",
            "/api/theory/cat/**",
            "/theory-detail/**",
            "/theory-cat",
            "/api/theory/cat",
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
            "/account/update-password",
            "/api/thread/update"

    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/account/register",
            "/account/reset-password",
            "/account/login",
            "/api/thread/add",
            "/api/thread/add/**",
            "/api/thread/comment/add",
            "/api/thread/comment/add/**",
            "/api/thread/image/add"

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

            "/thread-cat",
            "/thread-cat/**",

            "/thread",
            "/thread/**",

            "/thread-comment",
            "/thread-comment/**",

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

            "/api/page/add",

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

            "/api/thread/cat/add",

            "/api/thread/add",

            "/api/thread/comment/add",
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

            "/page",
            "/page/**",

            "/api/page/update",

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

            "/api/thread/cat/update",

            "/api/thread/update",

            "/api/thread/comment/update",
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

            "/page",
            "/page/**",

            "/theory-detail",
            "/theory-detail/**",
            "/theory-cat",
            "/theory-cat/**",
            "/theory-example",
            "/theory-example/**",
            "/theory-keyword",
            "/theory-keyword/**",

            "/thread-cat",
            "/thread-cat/**",

            "/thread",
            "/thread/**",

            "/thread-comment",
            "/thread-comment/**",
    };
}
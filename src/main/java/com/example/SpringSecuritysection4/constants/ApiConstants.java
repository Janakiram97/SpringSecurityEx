package com.example.SpringSecuritysection4.constants;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public enum ApiConstants {

    ACCOUNT(new AntPathRequestMatcher("/myAccount")),
    CARDS(new AntPathRequestMatcher("/myCards")),
    BALANCE(new AntPathRequestMatcher("/mybalance"));

    private RequestMatcher requestMatcher;

    ApiConstants(RequestMatcher requestMatcher){
        this.requestMatcher=requestMatcher;
    }

    public RequestMatcher getRequestMatcher() {
        return requestMatcher;
    }
}

package com.loljoa.server.security.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetCookie {
    public static String getCookieValue(HttpServletRequest request, String key) {
        if(request.getCookies() == null) {
            return "";
        }
        for(Cookie cookie : request.getCookies()) {
            if(cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return "";
    }
}

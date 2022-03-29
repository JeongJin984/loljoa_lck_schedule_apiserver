package com.loljoa.server.security.util;

import org.springframework.security.web.authentication.rememberme.InvalidCookieException;

public class GetAccount {

    public static String getAccount(String platform, String auth_token) {
        switch (platform) {
            case "naver":
                return "naverTemp";
            case "kakao":
                return "kakaoTemp";
        }
        throw new InvalidCookieException(platform + "에 유저가 조회되지 않습니다.");
    }
}

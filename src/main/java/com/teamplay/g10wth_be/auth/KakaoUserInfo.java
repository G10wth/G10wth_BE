package com.teamplay.g10wth_be.auth;

import lombok.Getter;

import java.util.Map;

@Getter
public class KakaoUserInfo {
    private final String email;
    private final String nickname;

    public KakaoUserInfo(Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map) attributes.get("kakao_account");
        Map<String, Object> profile = (Map) kakaoAccount.get("profile");
        this.email = (String) kakaoAccount.get("email");
        this.nickname = (String) profile.get("nickname");
    }
}
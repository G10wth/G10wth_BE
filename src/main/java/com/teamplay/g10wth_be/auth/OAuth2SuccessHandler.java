package com.teamplay.g10wth_be.auth;


import com.teamplay.g10wth_be.auth.service.OAuth2Service;
import com.teamplay.g10wth_be.domain.member.entity.Member;
import com.teamplay.g10wth_be.domain.member.service.MemberService;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final OAuth2Service oAuth2Service;
    private final JwtTokenProvider jwtProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse res,
                                        Authentication auth) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) auth.getPrincipal();
        KakaoUserInfo kakao = new KakaoUserInfo(oAuth2User.getAttributes());

        Member member = oAuth2Service.handleOAuthLogin(kakao.getEmail(), kakao.getNickname());
        String token = jwtProvider.createToken(member.getId(), member.getRole().name());

        String redirectUrl = UriComponentsBuilder.fromUriString("http://localhost:3000/oauth")
                .queryParam("token", token)
                .build().toUriString();
        res.sendRedirect(redirectUrl);
    }
}
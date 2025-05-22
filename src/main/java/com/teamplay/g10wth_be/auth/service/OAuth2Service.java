package com.teamplay.g10wth_be.auth.service;

import com.teamplay.g10wth_be.domain.member.entity.Member;
import com.teamplay.g10wth_be.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2Service {
    @Lazy
    private final MemberService memberService;

    public Member handleOAuthLogin(String email, String nickname) {
        return memberService.saveOrGetKakao(email, nickname);
    }
}
package com.teamplay.g10wth_be.domain.member.service;

import com.teamplay.g10wth_be.domain.member.dto.SignupRequest;
import com.teamplay.g10wth_be.domain.member.entity.Member;
import com.teamplay.g10wth_be.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepo;
    private final PasswordEncoder passwordEncoder;

    // 로컬 회원가입
    public void signup(SignupRequest dto) {
        memberRepo.findByEmail(dto.email()).ifPresent(m -> {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        });
        memberRepo.save(Member.builder()
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .nickname(dto.nickname())
                .role(Member.Role.USER)
                .provider(Member.Provider.LOCAL)
                .build());
    }

    // 카카오 로그인 → 내부 회원 조회·생성
    public Member saveOrGetKakao(String email, String nickname) {
        return memberRepo.findByEmail(email).orElseGet(() ->
                memberRepo.save(Member.builder()
                        .email(email)
                        .password(null)
                        .nickname(nickname)
                        .role(Member.Role.USER)
                        .provider(Member.Provider.KAKAO)
                        .build()));
    }
}
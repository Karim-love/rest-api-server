package com.karim.restApiServer.service;

import com.karim.restApiServer.domain.Member;
import com.karim.restApiServer.repository.MemberRepository;
import com.karim.restApiServer.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member){

        // 같은 이름이 있는 멤버 중복 허용 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getUserId();
    }

    // ctrl + alt + shift + T = extract method
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getUserName())
                .ifPresent( member1 -> { // result에 이미 값이 있으면 exception throw
                    throw new IllegalStateException("이미 존재하는 회원");
                } );
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

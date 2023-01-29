package com.karim.restApiServer.repository;

import com.karim.restApiServer.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : karim
 * date           : 2023-01-28 오후 01:18
 * description    : 메모리에 사용자를 저장하고 조화하기 위한 구현체
 */

public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long seqeunce = 0L;

    @Override
    public Member save(Member member) {
        member.setUserId(++seqeunce);
        store.put( member.getUserId(), member );
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter( member ->  member.getUserName().equals(name) )
                .findAny(); // 하나라도 찾으면 바로 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

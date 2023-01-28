package com.karim.restApiServer.repository;

import com.karim.restApiServer.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : com.karim.restApiServer.controller
 * author         : karim
 * date           : 2023-01-28 오후 01:18
 * description    : 사용자를 저장하고 조화하기 위한 인터페이스
 */
public interface UserRepository {

    Member save(Member user);

    // Optional
    // : 자바8에 들어간 기능
    //   가져오는 값이 없으면 null로 감싸서 반환
    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

}

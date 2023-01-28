package com.karim.restApiServer.repository;

import com.karim.restApiServer.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryUserRepositoryTest {

    UserRepository repository = new MemoryUserRepository();

    @Test
    @Disabled
    public void save() {

        Member member = new Member();
        member.setUserName("karim");
        repository.save(member);
        Member result = repository.findById(member.getUserId()).get();

        System.out.println(result);
    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setUserName("karim");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUserName("karim2");
        repository.save(member2);

        Member result = repository.findByName("karim").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    @Disabled
    public void findAll() {
        Member member1 = new Member();
        member1.setUserName("karim");
        repository.save(member1);

        Member member2 = new Member();
        member2.setUserName("karim2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
package com.karim.restApiServer;

import com.karim.restApiServer.repository.MemberRepository;
import com.karim.restApiServer.repository.MemoryMemberRepository;
import com.karim.restApiServer.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService( memberRepository() );
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

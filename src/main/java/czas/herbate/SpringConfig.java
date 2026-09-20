package czas.herbate;

import czas.herbate.repository.MemberRepository;
import czas.herbate.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // Spring Data JPA auto-registers SpringDataJpaMemberRepository as the MemberRepository bean.
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}

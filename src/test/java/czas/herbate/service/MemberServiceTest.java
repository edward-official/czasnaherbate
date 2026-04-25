package czas.herbate.service;

import czas.herbate.domain.Member;
import czas.herbate.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void signUp() throws Exception {
        // given
        Member member = new Member();
        member.setName("czas");

        // when
        Long saveId = memberService.signUp(member);

        // then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void checkDuplicateNames() throws Exception {
        Member member1 = new Member();
        member1.setName("czas");

        Member member2 = new Member();
        member2.setName("czas");

        memberService.signUp(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.signUp(member2);
        });
        Assertions.assertThat(e.getMessage()).isEqualTo("Duplicated user name.");
    }

}
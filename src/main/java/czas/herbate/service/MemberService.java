package czas.herbate.service;

import czas.herbate.domain.Member;
import czas.herbate.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Service: A Spring Bean annotation for the business logic layer.
 * 
 * IoC (Inversion of Control): Instead of the developer manually creating objects (new MemberService()), 
 * the Spring Container manages the object's lifecycle.
 * 
 * DI (Dependency Injection): Spring "injects" the required dependency (MemberRepository) 
 * into the service when it creates the bean.
 */
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * Constructor Injection: The recommended way to perform DI.
     * Spring finds the MemberRepository bean and provides it here.
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signUp(Member member) {
        checkDuplicateName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void checkDuplicateName(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("Duplicated user name.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}

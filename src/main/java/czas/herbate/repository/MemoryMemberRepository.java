package czas.herbate.repository;

import czas.herbate.domain.Member;

import java.util.*;

/**
 * @Repository: A Spring Bean annotation for the data access layer.
 * By adding this, Spring automatically registers this class as a "Bean" in the IoC Container.
 * It also translates database-specific exceptions into Spring's DataAccessException.
 */
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // currently not considering concurrency issues
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

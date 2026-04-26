package czas.herbate.repository;

import czas.herbate.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * Repository: An abstraction layer for data access.
 * This interface defines the contract for storing and retrieving Domain objects (Member).
 * By using an interface, we can easily switch between different implementations 
 * (e.g., Memory-based vs. Database-based) without changing the business logic.
 */
public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

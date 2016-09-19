package com.example.repository;


import com.example.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jarvis on 2016. 9. 19..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
  Long countByEmailAndPassword(String email, String password);
}

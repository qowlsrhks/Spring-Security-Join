package com.example.spring_bank.repository;

import com.example.spring_bank.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    Optional<MemberEntity> findByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
    boolean existsByMemberEmail(String memberEmail);

}

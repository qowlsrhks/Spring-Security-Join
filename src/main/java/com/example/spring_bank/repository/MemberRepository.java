package com.example.spring_bank.repository;

import com.example.spring_bank.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    MemberEntity findByMemberId(String memberId);

    boolean existsByMemberId(String memberId);
    boolean existsByMemberEmail(String memberEmail);

}

package com.example.spring_bank.repository;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByMemberEmail(String memberEmail);
    boolean existsByMemberEmail(String memberEmail);

    boolean existsByMemberPhone(String memberPhone);


}

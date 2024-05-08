package com.example.spring_bank.dto;

import com.example.spring_bank.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails{

    private final MemberEntity memberEntity;

    public CustomUserDetails(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return memberEntity.getMemberRole().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return memberEntity.getMemberPw();
    }

    @Override
    public String getUsername() {
        return memberEntity.getMemberEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

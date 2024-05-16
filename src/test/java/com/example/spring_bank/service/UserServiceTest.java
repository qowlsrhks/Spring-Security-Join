package com.example.spring_bank.service;

import com.example.spring_bank.entity.MemberEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest{


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        String memberEmail = "skswlsrhks@naver.com";
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberEmail);
        memberEntity.setMemberPw("wlsrhks931@");
        memberEntity.setEnabled(true);
        memberEntity.setRoles(Collections.singleton(new Role()));

        when(userRepository.findByMemberEmail(memberEmail)).thenReturn(Optional.of(memberEntity));

        UserDetails userDetails = userService.loadUserByUsername(memberEmail);

        assertNotNull(userDetails);
        assertEquals(memberEmail, userDetails.getUsername());
        assertEquals("wlsrhks931@", userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertEquals(1, userDetails.getAuthorities().size());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void loadUserByUsername_userNotFound_throwsUsernameNotFoundException() {
        String memberEmail = "nonexistent@example.com";
        when(userRepository.findByMemberEmail(memberEmail)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(memberEmail));
    }
}
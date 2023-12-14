package com.example.scarecrow.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.scarecrow.dto.UserDto;
import com.example.scarecrow.repository.UserRepository;
import com.example.scarecrow.user.UserRole;

import lombok.RequiredArgsConstructor;

//생성자 자동 생성 어노테이션
@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// 사용자 이름으로 사용자 정보를 찾기
        Optional<UserDto> _siteUser = this.userRepository.findByusername(username);
        
        // 사용자 정보가 없는 경우 오류를 발생
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        UserDto siteUser = _siteUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        // 사용자 이름이 "admin"인 경우 ADMIN 권한을, 그렇지 않은 경우 USER 권한을 부여
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
    }
}
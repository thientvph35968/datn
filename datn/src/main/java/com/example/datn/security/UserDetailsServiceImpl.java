package com.example.datn.security;

import com.example.datn.entity.User;
import com.example.datn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

// @Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // @Autowired
    // private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {
        // User user = userRepository.findByTaiKhoan(taiKhoan)
        //         .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy tài khoản: " + taiKhoan));
        // return new CustomUserDetails(user);
        throw new UsernameNotFoundException("Service tạm thời bị vô hiệu hóa");
    }
}

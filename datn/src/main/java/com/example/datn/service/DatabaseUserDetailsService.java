package com.example.datn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

// @Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            String sql = "SELECT nv.MatKhau, vt.MaVaiTro " +
                    "FROM NhanVien nv " +
                    "JOIN VaiTro vt ON nv.ID_VaiTro = vt.ID_VaiTro " +
                    "WHERE nv.TaiKhoan = ?";

            Map<String, Object> row = jdbcTemplate.queryForMap(sql, username);
            String password = (String) row.get("MatKhau");
            String maVaiTro = (String) row.get("MaVaiTro");

            // map MaVaiTro -> ROLE_...
            String role;
            if ("VT01".equalsIgnoreCase(maVaiTro)) {
                role = "ROLE_ADMIN";
            } else {
                role = "ROLE_EMPLOYEE";
            }

            return User.withUsername(username)
                    .password(password) // plain text (NoOp encoder)
                    .authorities(AuthorityUtils.createAuthorityList(role))
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();

        } catch (EmptyResultDataAccessException ex) {
            throw new UsernameNotFoundException("Không tìm thấy user: " + username);
        }
    }
}

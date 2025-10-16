package com.example.datn.controller;

import com.example.datn.entity.User;
import com.example.datn.entity.VaiTro;
import com.example.datn.repository.UserRepository;
import com.example.datn.repository.VaiTroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private VaiTroRepository vaiTroRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/create-test-user")
    public String createTestUser() {
        try {
            // Kiểm tra xem đã có user admin chưa
            Optional<User> existingUser = userRepository.findByTaiKhoan("admin");
            if (existingUser.isPresent()) {
                return "User admin đã tồn tại! Username: admin, Password: 123456";
            }

            // Tạo hoặc lấy vai trò ADMIN
            VaiTro adminRole;
            Optional<VaiTro> existingRole = vaiTroRepository.findByMaVaiTro("ADMIN");
            if (existingRole.isPresent()) {
                adminRole = existingRole.get();
            } else {
                // Sử dụng constructor thay vì setter
                adminRole = VaiTro.builder()
                        .maVaiTro("ADMIN")
                        .tenVaiTro("ADMIN")
                        .trangThai(true)
                        .build();
                adminRole = vaiTroRepository.save(adminRole);
            }

            // Tạo user test
            User testUser = new User();
            testUser.setMaNhanVien("NV001");
            testUser.setTenNhanVien("Admin Test");
            testUser.setGioiTinh("Nam");
            testUser.setTaiKhoan("admin");
            testUser.setMatKhau("123456"); // Mật khẩu không mã hóa
            testUser.setSdt("0123456789");
            testUser.setEmail("admin@test.com");
            testUser.setDiaChi("Test Address");
            testUser.setTrangThai(true);
            testUser.setVaiTro(adminRole);

            userRepository.save(testUser);
            return "Tạo user test thành công! Username: admin, Password: 123456";
        } catch (Exception e) {
            return "Lỗi khi tạo user test: " + e.getMessage();
        }
    }
}
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
@RequestMapping("/debug")
public class DebugController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private VaiTroRepository vaiTroRepository;

    // Kiểm tra kết nối database
    @GetMapping("/database")
    public String checkDatabase() {
        try {
            long userCount = userRepository.count();
            long roleCount = vaiTroRepository.count();
            return "Database OK! Users: " + userCount + ", Roles: " + roleCount;
        } catch (Exception e) {
            return "Database ERROR: " + e.getMessage();
        }
    }

    // Kiểm tra tất cả user
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Kiểm tra tất cả vai trò
    @GetMapping("/roles")
    public List<VaiTro> getAllRoles() {
        return vaiTroRepository.findAll();
    }

    // Kiểm tra user admin cụ thể
    @GetMapping("/check-admin")
    public String checkAdmin() {
        try {
            Optional<User> adminUser = userRepository.findByTaiKhoan("admin");
            if (adminUser.isPresent()) {
                User user = adminUser.get();
                return "Admin user found: " + 
                       "Username: " + user.getTaiKhoan() + 
                       ", Password: " + user.getMatKhau() + 
                       ", Role: " + (user.getVaiTro() != null ? user.getVaiTro().getTenVaiTro() : "NULL");
            } else {
                return "Admin user NOT found!";
            }
        } catch (Exception e) {
            return "Error checking admin: " + e.getMessage();
        }
    }

    // Tạo user admin đơn giản
    @GetMapping("/create-simple-admin")
    public String createSimpleAdmin() {
        try {
            // Xóa user admin cũ nếu có
            userRepository.findByTaiKhoan("admin").ifPresent(userRepository::delete);
            
            // Tạo vai trò ADMIN đơn giản
            VaiTro adminRole = new VaiTro();
            adminRole.setId(1L);
            adminRole.setMaVaiTro("ADMIN");
            adminRole.setTenVaiTro("ADMIN");
            adminRole.setTrangThai(true);
            adminRole = vaiTroRepository.save(adminRole);

            // Tạo user admin đơn giản
            User adminUser = new User();
            adminUser.setId(1L);
            adminUser.setMaNhanVien("ADMIN001");
            adminUser.setTenNhanVien("Admin User");
            adminUser.setGioiTinh("Nam");
            adminUser.setTaiKhoan("admin");
            adminUser.setMatKhau("123456");
            adminUser.setSdt("0123456789");
            adminUser.setEmail("admin@test.com");
            adminUser.setDiaChi("Test Address");
            adminUser.setTrangThai(true);
            adminUser.setVaiTro(adminRole);

            userRepository.save(adminUser);
            return "Tạo admin user thành công! Username: admin, Password: 123456";
        } catch (Exception e) {
            return "Lỗi tạo admin: " + e.getMessage();
        }
    }
}
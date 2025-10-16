package com.example.datn.controller;

import com.example.datn.entity.User;
import com.example.datn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        // Lấy danh sách tất cả user để debug
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@RequestParam String taiKhoan, 
                             @RequestParam String matKhau,
                             @RequestParam String tenNhanVien) {
        // Tạo user admin mẫu để test
        User admin = new User();
        admin.setTaiKhoan(taiKhoan);
        admin.setMatKhau(matKhau);
        admin.setTenNhanVien(tenNhanVien);
        admin.setTrangThai(true);
        
        userRepository.save(admin);
        return "redirect:/admin";
    }
}
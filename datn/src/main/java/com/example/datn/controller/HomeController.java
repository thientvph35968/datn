package com.example.datn.controller;

import com.example.datn.model.Product;
import com.example.datn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    // Trang chủ
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        // Lấy danh sách sản phẩm đang sale
        List<Product> saleProducts = productService.getSaleProducts();

        // Truyền danh sách sản phẩm sang view (home.html)
        model.addAttribute("saleProducts", saleProducts);

        // Trả về tên file giao diện (home.html trong templates)
        return "home";

    }
    @GetMapping("/login")
    public String loginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        // Thêm logic để hiển thị thông báo lỗi/logout trên giao diện
        if (error != null) {
            model.addAttribute("loginError", "Sai tài khoản hoặc mật khẩu!");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Bạn đã đăng xuất thành công.");
        }

        return "login"; // trả về file login.html
    }
    @GetMapping("/giohang")
    public String giohang() {
        return "giohang"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/quanlynguoidung")
    public String quanlynguoidung() {
        return "quanlynguoidung"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/quanlysanpham")
    public String quanlysanpham() {
        return "quanlysanpham"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/quanlyhoadon")
    public String quanlyhoadon() {
        return "quanlyhoadon"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/quanlydanhmuc")
    public String quanLyDanhMuc() {
        return "quanlydanhmuc";
    }

    @GetMapping("/quanlythuonghieu")
    public String quanLyThuongHieu() {
        return "quanlythuonghieu";
    }
    @GetMapping("/quanlybanhang")
    public String quanlybanhang() {
        return "quanlybanhang";
    }

    @GetMapping("/quanlymagiam")
    public String quanLyMaGiam() {
        return "quanlymagiam";
    }
    @GetMapping("/quenmatkhau")
    public String repass() {
        return "quenmatkhau"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/dangki")
    public String dangki() {
        return "dangki"; // trả về file login.html trong thư mục templates
    }
    @GetMapping("/collections/aokhoacparka")
    public String showParkaProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacparka"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoacsomi")
    public String showsomiProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacsomi"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoacjean")
    public String showjeanProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacjean"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoackaki")
    public String showkakiProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoackaki"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoacdu")
    public String showduProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacdu"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoacbomber")
    public String showbomberProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacbomber"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoachoodie")
    public String showhoodieProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoachoodie"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/aokhoacthethao")
    public String showttProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "aokhoacthethao"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/khampha")
    public String showxtProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "khampha"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/nike")
    public String showthProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "nike"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/adidas")
    public String showaProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "adidas"; // Tên file: product-listing.html
    }
    @GetMapping("/collections/giamgia")
    public String showddProducts(Model model) {

        // 1. Logic để lấy dữ liệu (Tùy chọn)
        // Ví dụ: List<SanPham> parkaProducts = productService.findProductsByCategory("Parka");
        // model.addAttribute("products", parkaProducts);

        // 2. Trả về tên của file HTML nằm trong thư mục templates
        return "giamgia"; // Tên file: product-listing.html
    }
}


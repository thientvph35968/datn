package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NhanVien") // đúng theo DB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NhanVien")
    private Long id;

    // 🔹 Liên kết đến bảng VaiTro
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VaiTro", referencedColumnName = "ID_VaiTro")
    private VaiTro vaiTro;

    @Column(name = "MaNhanVien", length = 20)
    private String maNhanVien;

    @Column(name = "TenNhanVien", length = 100)
    private String tenNhanVien;

    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @Column(name = "TaiKhoan", length = 50, unique = true)
    private String taiKhoan;

    @Column(name = "MatKhau", length = 255)
    private String matKhau;

    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "DiaChi", length = 255)
    private String diaChi;

    @Column(name = "TrangThai")
    private Boolean trangThai = true;

    // 🔹 Thêm thủ công getter này để chắc chắn CustomUserDetails truy cập được
    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public String getTenVaiTro() {
        return vaiTro != null ? vaiTro.getTenVaiTro() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    // Thêm setId method để tránh lỗi
    public void setId(Long id) {
        this.id = id;
    }
}

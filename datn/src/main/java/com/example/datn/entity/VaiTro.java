package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VaiTro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VaiTro")
    private Long id;

    @Column(name = "MaVaiTro", length = 20)
    private String maVaiTro;

    @Column(name = "TenVaiTro", length = 50)
    private String tenVaiTro;

    @Column(name = "TrangThai")
    private Boolean trangThai = true;

    @Override
    public String toString() {
        return this.tenVaiTro;
    }
    
    // Thêm các setter methods thủ công để tránh lỗi Lombok
    public void setMaVaiTro(String maVaiTro) {
        this.maVaiTro = maVaiTro;
    }
    
    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }
    
    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}

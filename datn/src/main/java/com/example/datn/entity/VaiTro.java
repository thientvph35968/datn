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
    public String getTenVaiTro() {
        return tenVaiTro;
    }
}

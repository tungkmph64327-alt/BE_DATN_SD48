// File: com/example/demo/entity/LoaiSanPham.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaLoaiSanPham", nullable = false)
    private String maLoaiSanPham;

    @Column(name = "TenLoaiSanPham", nullable = false)
    private String tenLoaiSanPham;

    // ... các thuộc tính khác (MoTa, TrangThai, ...)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }
    // ...
}
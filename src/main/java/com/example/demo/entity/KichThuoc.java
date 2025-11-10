package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "KichThuoc")
@Data
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaKichThuoc", nullable = false)
    private String maKichThuoc;

    @Column(name = "TenKichThuoc", nullable = false)
    private String tenKichThuoc; // Ví dụ: 36, S, M

    @Column(name = "TrangThai", nullable = false)
    private String trangThai; // Ví dụ: Hoạt động
}

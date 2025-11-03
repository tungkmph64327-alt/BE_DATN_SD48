package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ThuongHieu")
public class ThuongHieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TenThuongHieu", nullable = false)
    private String tenThuongHieu;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NgayTao", nullable = false)
    private LocalDateTime ngayTao;



    public Long getId() {
        return id;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }
}
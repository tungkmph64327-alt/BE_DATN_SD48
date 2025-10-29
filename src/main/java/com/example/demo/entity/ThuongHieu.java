package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ThuongHieu")
@Getter
@Setter
public class ThuongHieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TenThuongHieu", nullable = false, length = 255)
    private String tenThuongHieu;

    // Không cần khai báo các trường khác nếu chỉ dùng để hiển thị tên
}
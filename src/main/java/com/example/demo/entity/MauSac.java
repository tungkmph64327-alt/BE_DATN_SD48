package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime; // Cần thiết để ánh xạ kiểu DATETIME

@Entity
@Table(name = "MauSac")
@Data // Tự động tạo getter/setter/constructor (Khắc phục lỗi Setter)
public class MauSac {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // 1. MaHex: Đổi tên biến sang camelCase (maHex) để tuân thủ quy tắc Java
        @Column(name = "MaHex", nullable = false)
        private String maHex; // Ví dụ: #FFFFFF

        // 2. TenMau: Đã là camelCase
        @Column(name = "TenMau", nullable = false)
        private String tenMau; // Ví dụ: Trắng

        // 3. MoTa
        @Column(name = "MoTa")
        private String moTa;

        // 4. NgayTao: THÊM TRƯỜNG NÀY ĐỂ KHỚP VỚI CƠ SỞ DỮ LIỆU
        @Column(name = "NgayTao", nullable = false)
        private LocalDateTime ngayTao;

        // 5. NgayCapNhat: THÊM TRƯỜNG NÀY ĐỂ KHỚP VỚI CƠ SỞ DỮ LIỆU
        @Column(name = "NgayCapNhat")
        private LocalDateTime ngayCapNhat;

        // 🚫 KHÔNG CÓ TRƯỜNG 'MaMau' VÀ 'TrangThai' 🚫
}
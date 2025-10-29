package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Ten", nullable = false, length = 255)
    private String ten;

    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    @Column(name = "MoTa", length = 1000)
    private String moTa;

    // --- Mối quan hệ Many-to-One ---

    // Liên kết với bảng ThuongHieu (ID_ThuongHieu)
    @ManyToOne
    @JoinColumn(name = "ID_ThuongHieu")
    private ThuongHieu thuongHieu;

    // Liên kết với bảng LoaiSanPham (ID_LoaiSanPham)
    @ManyToOne
    @JoinColumn(name = "ID_LoaiSanPham")
    private LoaiSanPham loaiSanPham;

    // Liên kết với bảng ChatLieu (ID_ChatLieu)
    @ManyToOne
    @JoinColumn(name = "ID_ChatLieu")
    private ChatLieu chatLieu;
}
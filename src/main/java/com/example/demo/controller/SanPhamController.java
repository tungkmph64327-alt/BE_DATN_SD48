package com.example.demo.controller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; // 1. THÊM IMPORT

import java.util.List;

@RestController
@RequestMapping("/api/v1/sanpham")
@CrossOrigin(origins = "*") // 2. THÊM ANNOTATION CORS: Cho phép mọi domain truy cập
public class SanPhamController {

    private final SanPhamService sanPhamService; // Nên dùng final cho Constructor Injection

    // Chuyển sang Constructor Injection (khuyến nghị trong Spring)
    @Autowired
    public SanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    // Endpoint: GET http://localhost:8080/api/v1/sanpham
    @GetMapping
    public ResponseEntity<List<SanPham>> getAllSanPhams() {
        List<SanPham> sanPhams = sanPhamService.getAllSanPhams();
        return ResponseEntity.ok(sanPhams);
    }
}
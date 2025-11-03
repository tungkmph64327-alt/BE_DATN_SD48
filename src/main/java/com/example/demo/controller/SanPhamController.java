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
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import com.example.demo.dto.SimpleProductDto; // Import DTO mới
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/v1/sanpham")
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
    @GetMapping("/options")
    public ResponseEntity<List<Map<String, Object>>> getProductOptions() {
        List<SanPham> sanPhams = sanPhamService.getAllSanPhams();

        // Mapping chỉ lấy ID và Tên
        List<Map<String, Object>> result = sanPhams.stream()
                .map(sp -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", sp.getId());
                    map.put("name", sp.getTen());
                    return map;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
    @GetMapping("/search")
    public ResponseEntity<List<SimpleProductDto>> searchProducts(
            @RequestParam("keyword") String keyword) {

        List<SimpleProductDto> results = sanPhamService.searchProductsByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}

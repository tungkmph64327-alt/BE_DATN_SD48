package com.example.demo.controller;

import com.example.demo.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/loaisanpham")
public class LoaiSanPhamController {

    private final LoaiSanPhamService loaiSanPhamService;

    @Autowired
    public LoaiSanPhamController(LoaiSanPhamService loaiSanPhamService) {
        this.loaiSanPhamService = loaiSanPhamService;
    }

    @GetMapping("/options")
    public ResponseEntity<List<Map<String, Object>>> getCategoryOptions() {
        List<Map<String, Object>> options = loaiSanPhamService.getCategoryOptions();
        return ResponseEntity.ok(options);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchCategories(
            @RequestParam("keyword") String keyword) {

        List<Map<String, Object>> results = loaiSanPhamService.searchCategoriesByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}
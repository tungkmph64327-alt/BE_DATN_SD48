// KichThuocController.java (CẬP NHẬT)

package com.example.demo.controller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.service.KichThuocService;
import com.example.demo.dto.SimpleSizeDto; // 🌟 IMPORT DTO MỚI 🌟
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // 🌟 THÊM POSTMAPPING 🌟

import java.util.List;

@RestController
@RequestMapping("/api/v1/kichco")
@RequiredArgsConstructor
public class KichThuocController {

    private final KichThuocService kichThuocService;

    // Endpoint: GET /api/v1/kichco/options
    @GetMapping("/options")
    public ResponseEntity<List<KichThuoc>> getAllSizesForOptions() {
        return ResponseEntity.ok(kichThuocService.findAll());
    }

    // 🌟 ENDPOINT MỚI: POST /api/v1/kichco (Thêm mới) 🌟
    @PostMapping
    public ResponseEntity<KichThuoc> createKichThuoc(@RequestBody SimpleSizeDto request) {
        try {
            KichThuoc newKichThuoc = kichThuocService.createKichThuoc(request);
            return new ResponseEntity<>(newKichThuoc, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm kích thước: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
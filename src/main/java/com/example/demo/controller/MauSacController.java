// MauSacController.java (Đã sửa lỗi kiểu dữ liệu ID)

package com.example.demo.controller;

import com.example.demo.dto.SimpleColorDto;
import com.example.demo.service.MauSacService;
import com.example.demo.entity.MauSac;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mausac")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MauSacController {

    private final MauSacService mauSacService;

    // Endpoint 1: GET /api/v1/mausac/options (Lấy danh sách)
    @GetMapping("/options")
    public ResponseEntity<List<SimpleColorDto>> getAllColorsForOptions() {
        return ResponseEntity.ok(mauSacService.getAllColorOptions());
    }

    // Endpoint 2: POST /api/v1/mausac (Thêm mới)
    @PostMapping
    public ResponseEntity<MauSac> createMauSac(@RequestBody SimpleColorDto request) {
        try {
            MauSac newMauSac = mauSacService.createMauSac(request);
            return new ResponseEntity<>(newMauSac, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm màu sắc: " + e.getMessage());
            // Trả về lỗi 400 Bad Request nếu có lỗi xử lý
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Endpoint 3: PUT /api/v1/mausac/{id} (Cập nhật)
    // 🌟 KHẮC PHỤC LỖI: Đổi @PathVariable từ int/Integer sang Long 🌟
    @PutMapping("/{id}")
    public ResponseEntity<MauSac> updateMauSac(
            @PathVariable("id") Long id, // PHẢI DÙNG LONG
            @RequestBody SimpleColorDto request
    ) {
        try {
            MauSac updatedMauSac = mauSacService.updateMauSac(id, request);
            return ResponseEntity.ok(updatedMauSac);
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật màu sắc ID: " + id + ", Lỗi: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
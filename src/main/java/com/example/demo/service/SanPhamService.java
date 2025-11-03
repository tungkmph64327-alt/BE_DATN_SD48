package com.example.demo.service;

import com.example.demo.entity.SanPham;
import com.example.demo.dto.SimpleProductDto; // Import DTO mới
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAllSanPhams() {
        // Trả về danh sách sản phẩm lấy từ Repository
        return sanPhamRepository.findAll();
    }
    public List<SimpleProductDto> searchProductsByKeyword(String keyword) {
        // 1. Gọi Repository (đã sửa tên phương thức)
        List<SanPham> sanPhams = sanPhamRepository.findByTenContainingIgnoreCase(keyword);

        // 2. Ánh xạ (Map) từ Entity sang SimpleProductDto
        return sanPhams.stream()
                .map(sp -> new SimpleProductDto(sp.getId(), sp.getTen())) // *** SỬA TẠI ĐÂY: Dùng getTen() ***
                .collect(Collectors.toList());
    }
}
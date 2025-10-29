package com.example.demo.service;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPham> getAllSanPhams() {
        // Trả về danh sách sản phẩm lấy từ Repository
        return sanPhamRepository.findAll();
    }
}
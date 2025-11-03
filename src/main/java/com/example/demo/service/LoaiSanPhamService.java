package com.example.demo.service;

import com.example.demo.entity.LoaiSanPham;
import com.example.demo.repository.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoaiSanPhamService {

    private final LoaiSanPhamRepository loaiSanPhamRepository;

    @Autowired
    public LoaiSanPhamService(LoaiSanPhamRepository loaiSanPhamRepository) {
        this.loaiSanPhamRepository = loaiSanPhamRepository;
    }

    public List<Map<String, Object>> getCategoryOptions() {
        List<LoaiSanPham> allCategories = loaiSanPhamRepository.findAll();

        return allCategories.stream()
                .map(category -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", category.getId());
                    map.put("name", category.getTenLoaiSanPham());
                    return map;
                })
                .collect(Collectors.toList());
    }
    public List<Map<String, Object>> searchCategoriesByKeyword(String keyword) {
        List<LoaiSanPham> foundCategories = loaiSanPhamRepository.findByTenLoaiSanPhamContainingIgnoreCase(keyword);

        return foundCategories.stream()
                .map(category -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", category.getId());
                    map.put("name", category.getTenLoaiSanPham());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
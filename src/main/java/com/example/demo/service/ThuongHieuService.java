package com.example.demo.service;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class ThuongHieuService {

    private final ThuongHieuRepository thuongHieuRepository;

    @Autowired
    public ThuongHieuService(ThuongHieuRepository thuongHieuRepository) {
        this.thuongHieuRepository = thuongHieuRepository;
    }

    /**
     * Lấy danh sách Thương hiệu dưới dạng ID và Tên cho ComboBox.
     */
    public List<Map<String, Object>> getBrandOptions() {
        List<ThuongHieu> allBrands = thuongHieuRepository.findAll();

        // Ánh xạ sang List<Map<String, Object>> với 'id' và 'name'
        return allBrands.stream()
                .map(brand -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", brand.getId());
                    map.put("name", brand.getTenThuongHieu()); // Đặt tên là 'name' để Frontend dễ xử lý chung
                    return map;
                })
                .collect(Collectors.toList());
    }
    public List<Map<String, Object>> searchBrandsByKeyword(String keyword) {
        // Gọi phương thức JpaRepository đã định nghĩa
        List<ThuongHieu> foundBrands = thuongHieuRepository.findByTenThuongHieuContainingIgnoreCase(keyword);

        // Ánh xạ sang List<Map<String, Object>>
        return foundBrands.stream()
                .map(brand -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", brand.getId());
                    map.put("name", brand.getTenThuongHieu());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
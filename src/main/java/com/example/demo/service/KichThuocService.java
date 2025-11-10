// KichThuocService.java (CẬP NHẬT)

package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.dto.SimpleSizeDto; // 🌟 IMPORT DTO MỚI 🌟
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocService {
    @Autowired
    private KichThuocRepository kichThuocRepository;

    public List<KichThuoc> findAll() {
        return kichThuocRepository.findAll();
    }

    // 🌟 PHƯƠNG THỨC MỚI: TẠO KÍCH CỠ 🌟
    public KichThuoc createKichThuoc(SimpleSizeDto request) {
        // Có thể thêm logic kiểm tra trùng lặp maKichThuoc/tenKichThuoc ở đây

        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMaKichThuoc(request.getMaKichThuoc());
        kichThuoc.setTenKichThuoc(request.getTenKichThuoc());
        kichThuoc.setTrangThai("Hoạt động"); // Gán trạng thái mặc định

        return kichThuocRepository.save(kichThuoc);
    }
}
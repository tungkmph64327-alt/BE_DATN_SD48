package com.example.demo.repository;

import com.example.demo.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, Long> {
    List<LoaiSanPham> findByTenLoaiSanPhamContainingIgnoreCase(String keyword);
}
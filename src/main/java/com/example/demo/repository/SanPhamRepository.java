package com.example.demo.repository;

import com.example.demo.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> { // Chú ý: ID là Long

    // SỬA: Dùng 'Ten' để tìm kiếm theo trường @Column(name = "Ten")
    List<SanPham> findByTenContainingIgnoreCase(String ten);
}
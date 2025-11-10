// MauSacRepository.java

package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.dto.SimpleColorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Long> { // Đảm bảo dùng Long cho ID nếu Entity dùng Long

    /**
     * Truy vấn tất cả màu sắc và ánh xạ trực tiếp sang SimpleColorDto
     * (DTO Projection) để tối ưu hiệu suất.
     * @return Danh sách SimpleColorDto
     */
    @Query("SELECT new com.example.demo.dto.SimpleColorDto(m.id, m.tenMau, m.maHex) " +
            "FROM MauSac m") // KHÔNG CÓ WHERE M.trangThai
    List<SimpleColorDto> findAllSimpleColors();
}
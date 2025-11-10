// MauSacService.java

package com.example.demo.service;

import com.example.demo.dto.SimpleColorDto;
import com.example.demo.entity.MauSac;
import com.example.demo.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
// Có thể thay thế @Autowired bằng @RequiredArgsConstructor và final
// import lombok.RequiredArgsConstructor;
// @RequiredArgsConstructor
public class MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    // Nếu bạn dùng Lombok @RequiredArgsConstructor, có thể viết:
    // private final MauSacRepository mauSacRepository;

    // --- CHỨC NĂNG LẤY DANH SÁCH (GET) ---

    /**
     * Lấy danh sách màu sắc dưới dạng SimpleColorDto bằng DTO Projection.
     * Tối ưu hơn so với việc lấy toàn bộ Entity rồi map (findAll().stream().map()).
     *
     * @return Danh sách SimpleColorDto
     */
    public List<SimpleColorDto> getAllColorOptions() {
        // [CẬP NHẬT] Gọi phương thức DTO Projection mới
        return mauSacRepository.findAllSimpleColors();
    }

    // --- CHỨC NĂNG THÊM MỚI (POST) ---
    // Giữ nguyên các hàm còn lại của bạn
    // ...
    public MauSac updateMauSac(Long id, SimpleColorDto request) {
        // 1. Tìm Entity theo ID
        MauSac existingMauSac = mauSacRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Màu sắc với ID: " + id));

        // 2. Cập nhật các trường
        existingMauSac.setTenMau(request.getTenMau());
        existingMauSac.setMaHex(request.getMaHex());
        // ... (và trường NgayCapNhat nếu có)

        // 3. Lưu
        return mauSacRepository.save(existingMauSac);
    }
    public MauSac createMauSac(SimpleColorDto request) {
        MauSac mauSac = new MauSac();

        // 1. Lấy dữ liệu từ Request DTO
        mauSac.setTenMau(request.getTenMau());
        mauSac.setMaHex(request.getMaHex());

        // 2. Thiết lập Ngày tạo và Ngày cập nhật
        mauSac.setNgayTao(LocalDateTime.now());
        mauSac.setNgayCapNhat(LocalDateTime.now()); // Có thể set lần đầu là ngày tạo

        // 3. Lưu vào database
        return mauSacRepository.save(mauSac);
    }
}
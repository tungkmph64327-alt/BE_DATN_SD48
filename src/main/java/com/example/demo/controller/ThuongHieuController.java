// File: com/example/demo/controller/ThuongHieuController.java
package com.example.demo.controller;

import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/thuonghieu")
public class ThuongHieuController {

    private final ThuongHieuService thuongHieuService;

    @Autowired
    public ThuongHieuController(ThuongHieuService thuongHieuService) {
        this.thuongHieuService = thuongHieuService;
    }

    /**
     * Endpoint: GET /api/v1/thuonghieu/options
     * Trả về danh sách ID và TenThuongHieu cho ComboBox.
     */
    @GetMapping("/options")
    public ResponseEntity<List<Map<String, Object>>> getBrandOptions() {
        List<Map<String, Object>> options = thuongHieuService.getBrandOptions();
        return ResponseEntity.ok(options);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchBrands(
            @RequestParam("keyword") String keyword) {

        List<Map<String, Object>> results = thuongHieuService.searchBrandsByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}
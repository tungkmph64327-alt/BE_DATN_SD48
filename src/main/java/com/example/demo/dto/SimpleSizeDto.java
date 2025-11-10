
package com.example.demo.dto;

public class SimpleSizeDto {

    private String maKichThuoc;
    private String tenKichThuoc;
    // Không cần trường ID khi tạo mới

    // Constructors, Getters, Setters...
    public SimpleSizeDto() {}

    public SimpleSizeDto(String maKichThuoc, String tenKichThuoc) {
        this.maKichThuoc = maKichThuoc;
        this.tenKichThuoc = tenKichThuoc;
    }

    // Getters
    public String getMaKichThuoc() { return maKichThuoc; }
    public String getTenKichThuoc() { return tenKichThuoc; }

    // Setters
    public void setMaKichThuoc(String maKichThuoc) { this.maKichThuoc = maKichThuoc; }
    public void setTenKichThuoc(String tenKichThuoc) { this.tenKichThuoc = tenKichThuoc; }
}
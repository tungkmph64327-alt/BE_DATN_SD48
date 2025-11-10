package com.example.demo.dto;

public class SimpleColorDto {

    private Long id;
    private String tenMau;
    private String maHex;

    public SimpleColorDto() {}

    public SimpleColorDto(Long id, String tenMau, String maHex) {
        this.id = id;
        this.tenMau = tenMau;
        this.maHex = maHex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getMaHex() {
        return maHex;
    }

    public void setMaHex(String maHex) {
        this.maHex = maHex;
    }
}
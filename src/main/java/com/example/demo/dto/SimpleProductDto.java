package com.example.demo.dto;

public class SimpleProductDto {

    private Long id; // *** Đổi từ Integer sang Long ***
    private String name;

    // Constructor
    public SimpleProductDto(Long id, String name) { // *** Đổi kiểu tham số Constructor ***
        this.id = id;
        this.name = name;
    }

    // Getters và Setters
    public Long getId() { return id; } // *** Đổi kiểu trả về ***
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
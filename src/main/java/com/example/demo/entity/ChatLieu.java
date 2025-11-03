// File: com/example/demo/entity/ChatLieu.java
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChatLieu")
public class ChatLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MaChatLieu", nullable = false)
    private String maChatLieu;

    @Column(name = "TenChatLieu", nullable = false)
    private String tenChatLieu;

    // ... các thuộc tính khác (TrangThai, NguoiTao, NgayTao, ...)

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }
    // ...
}
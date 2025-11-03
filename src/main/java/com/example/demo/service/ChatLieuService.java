package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class ChatLieuService {

    private final ChatLieuRepository chatLieuRepository;

    @Autowired
    public ChatLieuService(ChatLieuRepository chatLieuRepository) {
        this.chatLieuRepository = chatLieuRepository;
    }

    public List<Map<String, Object>> getMaterialOptions() {
        List<ChatLieu> allMaterials = chatLieuRepository.findAll();

        return allMaterials.stream()
                .map(material -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", material.getId());
                    map.put("name", material.getTenChatLieu());
                    return map;
                })
                .collect(Collectors.toList());
    }
    public List<Map<String, Object>> searchMaterialsByKeyword(String keyword) {
        List<ChatLieu> foundMaterials = chatLieuRepository.findByTenChatLieuContainingIgnoreCase(keyword);

        return foundMaterials.stream()
                .map(material -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", material.getId());
                    map.put("name", material.getTenChatLieu());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
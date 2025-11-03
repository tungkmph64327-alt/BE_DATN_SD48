// File: com/example/demo/controller/ChatLieuController.java
package com.example.demo.controller;

import com.example.demo.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/chatlieu")
public class ChatLieuController {

    private final ChatLieuService chatLieuService;

    @Autowired
    public ChatLieuController(ChatLieuService chatLieuService) {
        this.chatLieuService = chatLieuService;
    }

    @GetMapping("/options")
    public ResponseEntity<List<Map<String, Object>>> getMaterialOptions() {
        List<Map<String, Object>> options = chatLieuService.getMaterialOptions();
        return ResponseEntity.ok(options);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchMaterials(
            @RequestParam("keyword") String keyword) {

        List<Map<String, Object>> results = chatLieuService.searchMaterialsByKeyword(keyword);
        return ResponseEntity.ok(results);
    }
}
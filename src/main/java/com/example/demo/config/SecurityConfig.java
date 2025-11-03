// File: com/example/demo/config/SecurityConfig.java
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Tắt cấu hình CORS mặc định (Sử dụng CorsConfig)
                .cors(cors -> cors.disable())

                // 1. Tắt CSRF
                .csrf(csrf -> csrf.disable())

                // 2. TẮT CÁC CƠ CHẾ XÁC THỰC CŨ
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                // 3. Cấu hình Session (Stateless)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // 4. Cấu hình ủy quyền (Authorization)
                .authorizeHttpRequests(auth -> auth

                        // [PERMIT ALL] Cho phép tất cả các API Options và Search
                        .requestMatchers(HttpMethod.GET,
                                "/api/v1/sanpham/search*",
                                "/api/v1/sanpham/options",
                                "/api/v1/thuonghieu/options",
                                "/api/v1/chatlieu/options",
                                "/api/v1/loaisanpham/options",
                                "/api/v1/thuonghieu/search*",
                                "/api/v1/chatlieu/search*",
                                "/api/v1/loaisanpham/search*"
                        ).permitAll()

                        // Cho phép API GET chung của Sản phẩm (GET ALL, GET chi tiết)
                        .requestMatchers(HttpMethod.GET, "/api/v1/sanpham/**").permitAll()


                        // CÁC YÊU CẦU CÒN LẠI PHẢI XÁC THỰC
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
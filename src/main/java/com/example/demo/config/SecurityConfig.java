package com.example.demo.config; // Đảm bảo đúng package của bạn

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Tắt CSRF (Thường cần thiết cho FE/API)
                .csrf(csrf -> csrf.disable())

                // 2. Cấu hình ủy quyền (Authorization)
                .authorizeHttpRequests(auth -> auth
                        // [QUAN TRỌNG] Cho phép truy cập công khai vào API danh sách sản phẩm
                        .requestMatchers("/api/v1/sanpham").permitAll()

                        // Cho phép truy cập vào trang login (nếu đang dùng form mặc định)
                        .requestMatchers("/login").permitAll()

                        // Các yêu cầu khác (bất kỳ) phải được xác thực (phải login)
                        .anyRequest().authenticated()
                )

                // 3. Cấu hình Form Login (để Spring chuyển hướng nếu chưa đăng nhập)
                .formLogin(form -> form
                        .loginPage("/login") // Mặc định chuyển hướng tới /login
                        .permitAll()
                );

        return http.build();
    }
}
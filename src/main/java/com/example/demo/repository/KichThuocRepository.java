
package com.example.demo.repository;

import com.example.demo.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Long> {
    // Tương tự, Spring Data JPA cung cấp các phương thức cơ bản
}
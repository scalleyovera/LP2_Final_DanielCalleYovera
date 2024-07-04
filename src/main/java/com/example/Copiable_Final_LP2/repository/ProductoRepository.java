package com.example.Copiable_Final_LP2.repository;

import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {
}

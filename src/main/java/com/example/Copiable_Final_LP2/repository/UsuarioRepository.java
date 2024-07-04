package com.example.Copiable_Final_LP2.repository;

import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    public UsuarioEntity findByCorreo(String correo);
}

package com.example.Copiable_Final_LP2.service;

import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface UsuarioService {

    void crearUsuario(UsuarioEntity usuario, Model model, MultipartFile foto);
    boolean validarUsuario(UsuarioEntity usuario, HttpSession sesion);
    UsuarioEntity buscarUsuarioPorCorreo(String correo);
}

package com.example.Copiable_Final_LP2.controllers;

import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import com.example.Copiable_Final_LP2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String showRegistrarUsuario(Model model){
        UsuarioEntity user = new UsuarioEntity();
        model.addAttribute("usuario", user);
        return "/registrar_usuario";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(UsuarioEntity usuario,
                                   Model model, @RequestParam("foto") MultipartFile foto){
        usuarioService.crearUsuario(usuario, model, foto);
        return "registrar_usuario";
    }


    @GetMapping("/")
    public String showIndex(Model model){
        UsuarioEntity usuario = new UsuarioEntity();
        model.addAttribute("usuario", usuario);
        return "login";
    }


}

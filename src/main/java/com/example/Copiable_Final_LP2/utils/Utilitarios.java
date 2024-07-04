package com.example.Copiable_Final_LP2.utils;

import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.JDBCType;

public class Utilitarios {

    public static String guardarImagen(MultipartFile foto){

        try {
            Path pathDire = Paths.get("src/main/resources/static/UsuarioFoto/");
            if(!Files.exists(pathDire)){
                Files.createDirectories(pathDire);
            }

            byte[] bytes = foto.getBytes();
            Path path = Paths.get("src/main/resources/static/UsuarioFoto/" + foto.getOriginalFilename());
            Files.write(path, bytes);
            return foto.getOriginalFilename();
        } catch (IOException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public static String extraerHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean verificarPassword(String password, String hashPassword){
        return BCrypt.checkpw(password,hashPassword );
    }

}

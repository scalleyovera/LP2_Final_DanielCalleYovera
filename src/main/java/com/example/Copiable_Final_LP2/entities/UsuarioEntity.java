package com.example.Copiable_Final_LP2.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioEntity {

    @Id
    private String correo;

    private String nombre;
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private LocalDate fecNac;

    private String password;

    @Column(name = "url_imagen")
    private String urlImagen;

}

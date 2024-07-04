package com.example.Copiable_Final_LP2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer categoriaId;

    private String nombre;

}

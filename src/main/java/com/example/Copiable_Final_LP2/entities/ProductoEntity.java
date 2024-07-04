package com.example.Copiable_Final_LP2.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer productoId;

    @Column(name = "nombre", nullable = false)
    private String nombreProducto;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "fk_categoria_id", nullable = false)
    private CategoriaEntity categoria;




}

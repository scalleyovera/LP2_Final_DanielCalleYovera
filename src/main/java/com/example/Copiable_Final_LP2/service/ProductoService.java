package com.example.Copiable_Final_LP2.service;
import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import org.springframework.ui.Model;

import java.util.List;


public interface ProductoService {

    List<ProductoEntity> listarProductos();
    void crearProducto(ProductoEntity producto);
    ProductoEntity encontrarPorId(Integer id);
    void eliminarProducto(Integer id);
    void editarProducto(ProductoEntity producto, Integer id);
}

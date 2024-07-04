package com.example.Copiable_Final_LP2.service.Impl;

import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import com.example.Copiable_Final_LP2.repository.ProductoRepository;
import com.example.Copiable_Final_LP2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<ProductoEntity> listarProductos() {
        List<ProductoEntity> lista = productoRepository.findAll();
        return lista;
    }

    @Override
    public void crearProducto(ProductoEntity producto) {
        productoRepository.save(producto);
    }

    @Override
    public ProductoEntity encontrarPorId(Integer id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editarProducto(ProductoEntity producto, Integer id) {

    }
}

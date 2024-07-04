package com.example.Copiable_Final_LP2.service.Impl;

import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import com.example.Copiable_Final_LP2.repository.ProductoRepository;
import com.example.Copiable_Final_LP2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

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

        Optional<ProductoEntity> productoEncontrado = productoRepository.findById(id);

        if(productoEncontrado.isPresent()){
            ProductoEntity prodEditado = productoEncontrado.get();

            // Actualizar los campos del usuario encontrado con los nuevos valores
            prodEditado.setNombreProducto(producto.getNombreProducto());
            prodEditado.setPrecio(producto.getPrecio());
            prodEditado.setStock(producto.getStock());
            prodEditado.setCategoria(producto.getCategoria());

            // Guardar los cambios en la base de datos
            productoRepository.save(prodEditado);
        }

    }
}

package com.example.Copiable_Final_LP2.controllers;

import com.example.Copiable_Final_LP2.entities.CategoriaEntity;
import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import com.example.Copiable_Final_LP2.repository.CategoriaRepository;
import com.example.Copiable_Final_LP2.service.ProductoService;
import com.example.Copiable_Final_LP2.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ProductoService productoService;

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/menu")
    public String showMenu(HttpSession sesion, Model model){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/";
        }
        String correo = sesion.getAttribute("usuario").toString();

        model.addAttribute("usuarioEn", correo);

        //Send products to the view
        List<ProductoEntity> productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        return "menu";

    }

    @GetMapping("/buscar")
    public String buscarPorId(@RequestParam("id") Integer id, Model model, HttpSession sesion) {
        String correo = sesion.getAttribute("usuario").toString();
        model.addAttribute("usuarioEn", correo);

        try {
            ProductoEntity producto = productoService.encontrarPorId(id);

            if (producto != null) {
                model.addAttribute("productos", Arrays.asList(producto));
            } else {
                model.addAttribute("productos", Collections.emptyList());
            }

        } catch (Exception e) {
            model.addAttribute("productos", Collections.emptyList());
        }

        return "menu";
    }



    @GetMapping("/detalle_producto/{id}")
    public String verProducto(@PathVariable Integer id, Model model){
        ProductoEntity productoPorId = productoService.encontrarPorId(id);
        model.addAttribute("producto", productoPorId);
        return "detalle_producto";
    }



    @GetMapping("/registrar_producto")
    public String showRegistrarProducto(Model model){
        ProductoEntity producto = new ProductoEntity();
        model.addAttribute("producto", producto);

        List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);

        return "registrar_producto";
    }

    @PostMapping("/registrar_producto")
    public String registrarProducto(@ModelAttribute ProductoEntity producto, Model model){
        productoService.crearProducto(producto);
        return "redirect:/menu";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(Model model, @PathVariable("id") Integer id){
        productoService.eliminarProducto(id);
        return "redirect:/menu";
    }

    @GetMapping("/editar_producto/{id}")
    public String showEditarProducto(Model model, @PathVariable Integer id){
        ProductoEntity producto = productoService.encontrarPorId(id);
        model.addAttribute("producto", producto);

        List<CategoriaEntity> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);

        return "editar_producto";
    }

    @PostMapping("/editar_producto/{id}")
    public String editarProducto(@ModelAttribute ProductoEntity producto, @PathVariable Integer id){
        productoService.editarProducto(producto, id);
        return "redirect:/menu";
    }






}

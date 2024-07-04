package com.example.Copiable_Final_LP2.utils;

import com.example.Copiable_Final_LP2.entities.ProductoEntity;
import com.example.Copiable_Final_LP2.entities.UsuarioEntity;
import com.example.Copiable_Final_LP2.service.ProductoService;
import com.example.Copiable_Final_LP2.service.UsuarioService;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.FontFactory;
import jakarta.servlet.http.HttpSession;

import java.awt.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Component("menu")
public class ProductoPdf extends AbstractPdfView {

    @Autowired
    UsuarioService usuarioService;

    public ProductoPdf() {
        
    }


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<ProductoEntity> productos = (List<ProductoEntity>) model.get("productos");

        document.setPageSize(PageSize.LETTER.rotate()); // Configura el tamaño de la página (horizontal)
        document.open(); // Abre el documento para empezar a escribir

        // Tabla del título
        PdfPTable tablaTitulo = new PdfPTable(1);
        tablaTitulo.setWidthPercentage(100); // Ajusta al ancho completo de la página
        PdfPCell celdaTitulo = new PdfPCell(new Phrase("Lista de productos"));
        celdaTitulo.setBorder(0); // Sin bordes
        celdaTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaTitulo.addCell(celdaTitulo);
        tablaTitulo.setSpacingAfter(20); // Espacio después de la tabla

        // Tabla de los campos
        PdfPTable tablaCampos = new PdfPTable(5);
        tablaCampos.setWidthPercentage(100); // Ajusta al ancho completo de la página
        tablaCampos.addCell(new PdfPCell(new Phrase("Id de producto", FontFactory.getFont(FontFactory.HELVETICA_BOLD))));
        tablaCampos.addCell(new PdfPCell(new Phrase("Nombre", FontFactory.getFont(FontFactory.HELVETICA_BOLD))));
        tablaCampos.addCell(new PdfPCell(new Phrase("Precio", FontFactory.getFont(FontFactory.HELVETICA_BOLD))));
        tablaCampos.addCell(new PdfPCell(new Phrase("Stock", FontFactory.getFont(FontFactory.HELVETICA_BOLD))));
        tablaCampos.addCell(new PdfPCell(new Phrase("Categoría", FontFactory.getFont(FontFactory.HELVETICA_BOLD))));
        tablaCampos.setHeaderRows(1); // Define las primeras filas como encabezado (con formato)

        // Llena la tabla de campos con los datos de productos
        for (ProductoEntity producto : productos) {
            tablaCampos.addCell(String.valueOf(producto.getProductoId()));
            tablaCampos.addCell(producto.getNombreProducto());
            tablaCampos.addCell(String.valueOf(producto.getPrecio()));
            tablaCampos.addCell(String.valueOf(producto.getStock()));
            tablaCampos.addCell(producto.getCategoria().getNombre());
        }

        String nombresUsuario = usuarioService.mostrarNombresUsuario(request);

        PdfPTable tablaAutor = new PdfPTable(1);
        tablaAutor.setSpacingBefore(30);


        PdfPCell celdaAutor = new PdfPCell(new Phrase("Reporte generado por : " + nombresUsuario));
        celdaAutor.setBorder(0); // Sin bordes
        celdaAutor.setHorizontalAlignment(Element.ALIGN_LEFT);


        tablaAutor.addCell(celdaAutor);

        // Agrega las tablas al documento en el orden correcto
        document.add(tablaTitulo);
        document.add(tablaCampos);
        document.add(tablaAutor);

        // Cierra el documento
        document.close();
    }

}

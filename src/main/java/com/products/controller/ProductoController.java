package com.products.controller;


import com.products.entity.Producto;
import com.products.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductosService productoService;
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crear(producto), HttpStatus.CREATED);

    }
}

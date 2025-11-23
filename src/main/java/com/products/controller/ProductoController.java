package com.products.controller;


import com.products.entity.Producto;
import com.products.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductosService productoService;
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.crear(producto), HttpStatus.CREATED);

    }

@GetMapping
    public ResponseEntity<List<Producto>> listar(){
        return new ResponseEntity<>(productoService.listar(), HttpStatus.OK);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Producto>actualizarStock(@PathVariable Long id, @RequestBody Integer nuevoStock){
        return new ResponseEntity<>(productoService.actualizarStock(id, nuevoStock),HttpStatus.OK);
    }

}



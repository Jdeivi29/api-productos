package com.products.controller;

import com.products.dto.ResponseDTO;
import com.products.entity.Producto;
import com.products.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductosService productoService;

    @PostMapping
    public ResponseEntity<ResponseDTO> crear(@RequestBody Producto producto){
        ResponseDTO responseDTO = this.productoService.crear(producto);
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> listar(){
        ResponseDTO responseDTO = this.productoService.listar();
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<ResponseDTO>actualizarStock(@PathVariable Long id, @RequestBody Integer nuevoStock){
        ResponseDTO responseDTO = this.productoService.actualizarStock(id, nuevoStock);
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> eliminar(@PathVariable Long id) {
        ResponseDTO responseDTO = this.productoService.eliminar(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(responseDTO.getStatusCode()));
    }
}



package com.products.service;

import com.products.dto.ResponseDTO;
import com.products.entity.Producto;
import com.products.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository productoRepository;

    public ResponseDTO crear(Producto producto) {
        this.productoRepository.save(producto);
        return ResponseDTO.builder().statusCode(200).message("Producto creado.").data(producto).build();
    }

    public ResponseDTO listar() {
        List<Producto> listadoProductos = this.productoRepository.findAll();
        return ResponseDTO.builder().statusCode(200).message("OK").data(listadoProductos).build();
    }

    public ResponseDTO actualizarStock(Long id, Integer nuevoStock){
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto nuevoProducto = producto.get();
            nuevoProducto.setStock(nuevoStock);
            this.productoRepository.save(nuevoProducto);
            return ResponseDTO.builder().statusCode(200).message("Se actualizó el stock de " + producto.get().getStock() +" a " + nuevoStock).data(nuevoProducto).build();
        }
        return ResponseDTO.builder().statusCode(404).message("El id del producto no existe.").build();
    }

    public ResponseDTO eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseDTO.builder().statusCode(200).message("Producto eliminado.").build();
        }
        return ResponseDTO.builder().statusCode(404).message("El id del producto no existe.").build();
    }
}

package com.products.service;

import com.products.entity.Producto;
import com.products.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }
public java.util.List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto actualizarStock(Long id, Integer nuevoStock){
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto actualizar = producto.get();
            actualizar.setStock(nuevoStock);
            return productoRepository.save(actualizar);
        }
        return null;

    }

    public boolean eliminar(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

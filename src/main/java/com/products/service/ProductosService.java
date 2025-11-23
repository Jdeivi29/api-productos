package com.products.service;

import com.products.entity.Producto;
import com.products.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

package com.harold.apirest.apirest.Controllers;

import com.harold.apirest.apirest.Entities.Producto;
import com.harold.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el Producto con el Id"));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id,@RequestBody Producto productoDetails){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el Producto con el Id"));

        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontró el Producto con el ID: " +id));
        productoRepository.delete(producto);
        return "El producto con el ID: " + id + "fue eliminado correctamente";
    }
}

package com.harold.apirest.apirest.Repositories;

import com.harold.apirest.apirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}

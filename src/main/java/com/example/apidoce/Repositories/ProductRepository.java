package com.example.apidoce.Repositories;

import com.example.apidoce.Models.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {


        List<ProductEntity> findByCategoryIgnoreCase(String category);


}

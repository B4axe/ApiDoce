package com.example.apidoce.Repositories;

import com.example.apidoce.Models.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}

package com.example.apidoce.Repositories;

import com.example.apidoce.Models.CartEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<CartEntity, String> {
}

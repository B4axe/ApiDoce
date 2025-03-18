package com.example.apidoce.Repositories;

import com.example.apidoce.Models.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {

    Optional<ClientEntity> findByEmailAndPassword(String email, String password);

}

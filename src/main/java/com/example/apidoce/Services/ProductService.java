package com.example.apidoce.Services;

import com.example.apidoce.Models.ProductEntity;
import com.example.apidoce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> findAll(){
        return  repository.findAll();
    }

    public ProductEntity insert(ProductEntity entity){
        return repository.save(entity);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public ProductEntity updateStock(String id, int stock) {
        Optional<ProductEntity> productOpt = repository.findById(id);
        if (productOpt.isPresent()) {
            ProductEntity product = productOpt.get();
            product.setStock(product.getStock()+stock);
            return repository.save(product);
        }
        throw new RuntimeException("Produto não encontrado");
    }


}

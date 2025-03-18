package com.example.apidoce.Services;

import com.example.apidoce.Models.CartEntity;
import com.example.apidoce.Models.ItemEntity;
import com.example.apidoce.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Optional<CartEntity> findById(String id){
        return cartRepository.findById(id);
    }

    public CartEntity addItemToCart(String cartId, ItemEntity item) {
        Optional<CartEntity> optionalCart = cartRepository.findById(cartId);

        if (!optionalCart.isPresent()) {
            throw new RuntimeException("Carrinho não encontrado!");
        }

        CartEntity cart = optionalCart.get();
        cart.addItem(item);
        return cartRepository.save(cart);
    }

    public CartEntity createCart(){
        CartEntity newcart = new CartEntity();
        return cartRepository.save(newcart);
    }
}

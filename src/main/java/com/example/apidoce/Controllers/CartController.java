package com.example.apidoce.Controllers;

import com.example.apidoce.Models.CartEntity;
import com.example.apidoce.Models.ItemEntity;
import com.example.apidoce.Services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Operation(summary = "Adicionar o produto no carrinho")
    @PostMapping("/{cartId}/add-item")
    public ResponseEntity<?> addItem(@PathVariable String cartId, @RequestBody ItemEntity item) {
        try {
            CartEntity updatedCart = cartService.addItemToCart(cartId, item);
            return ResponseEntity.ok(updatedCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Criar um novo carrinho")
    @PostMapping("/create")
    public ResponseEntity<CartEntity> createCart() {
        CartEntity newCart = cartService.createCart();
        return ResponseEntity.status(HttpStatus.CREATED).body(newCart);
    }


    @Operation(summary = "Buscar carrinho por ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> findCartById(@PathVariable String id) {
        Optional<CartEntity> cart = cartService.findById(id);
        if (cart.isPresent()) {
            return ResponseEntity.ok(cart.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho não encontrado.");
    }

}

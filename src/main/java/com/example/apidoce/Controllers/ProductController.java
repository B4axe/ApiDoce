package com.example.apidoce.Controllers;


import com.example.apidoce.Models.ProductEntity;
import com.example.apidoce.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Retorna todos os produtos", description = "Busca todos os posts disponíveis no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos retornados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> getAllPosts() {
        List<ProductEntity> posts = service.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(
            summary = "Insere um novo produto",
            description = "Adiciona um produto ao banco de dados, fornecendo os detalhes do produto no corpo da requisição."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto inserido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductEntity.class),
                    examples = {
                            @ExampleObject(
                                    name = "Produto Exemplo 1",
                                    summary = "Exemplo de inserção de produto",
                                    value = "{\n  \"price\": 29.99,\n  \"name\": \"Chocolate\",\n  \"category\": \"Doces\",\n  \"description\": \"Chocolate ao leite 70% cacau\",\n  \"stock\": 100\n}"
                            ),
                            @ExampleObject(
                                    name = "Produto Exemplo 2",
                                    summary = "Outro exemplo de inserção de produto",
                                    value = "{\n  \"price\": 15.50,\n  \"name\": \"Bala de Goma\",\n  \"category\": \"Doces\",\n  \"description\": \"Balas de goma sortidas\",\n  \"stock\": 200\n}"
                            )
                    }
            )
    )
    @PostMapping("/insert")
    public ProductEntity insertPost(@RequestBody ProductEntity product) {

        return service.insert(product);
    }

    @Operation(
            summary = "Deleta um produto",
            description = "Remove um produto do banco de dados com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>("Produto deletado com sucesso!", HttpStatus.OK);
    }

    @Operation(
            summary = "Atualiza o estoque de um produto",
            description = "Modifica a quantidade em estoque de um produto com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estoque atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @PutMapping("/update-stock/{id}")
    public ResponseEntity<ProductEntity> updateStock(@PathVariable String id, @RequestParam int stock) {
        ProductEntity updatedProduct = service.updateStock(id, stock);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @Operation(
            summary = "Busca produtos por categoria",
            description = "Retorna uma lista de produtos filtrados pela categoria especificada na URL."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum produto encontrado para essa categoria"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductEntity>> getByCategory(@PathVariable String category) {
        List<ProductEntity> products = service.findByCategory(category);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}

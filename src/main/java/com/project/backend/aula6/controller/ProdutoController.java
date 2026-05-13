package com.project.backend.aula6.controller;
import com.project.backend.aula6.model.Produto;
import com.project.backend.aula6.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarUm(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoService.listarUmProduto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable UUID id, @RequestBody Produto produto) {
        Produto result = produtoService.atualizarProduto(id, produto);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok (produtoService.atualizarProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletar(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoService.deletarProduto(id));
    }
}

package com.micro.produto.controller;

import com.micro.produto.model.Produto;
import com.micro.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto salvar(@RequestBody Produto p) {
        return service.salvar(p);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        return service.buscar(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto p) {
        return service.buscar(id).map(produto -> {
            produto.setNome(p.getNome());
            produto.setDescricao(p.getDescricao());
            produto.setPreco(p.getPreco());
            return ResponseEntity.ok(service.salvar(produto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


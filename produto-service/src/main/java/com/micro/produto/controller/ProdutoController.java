package com.micro.produto.controller;

import com.micro.produto.dto.ProdutoDTO;
import com.micro.produto.mapper.ProdutoMapper;
import com.micro.produto.model.Produto;
import com.micro.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody @Valid ProdutoDTO dto) {
        Produto entity = ProdutoMapper.toEntity(dto);
        Produto saved  = service.salvar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoMapper.toDTO(saved));
    }

    // READ - list
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<ProdutoDTO> out = service.listar()
                .stream().map(ProdutoMapper::toDTO).toList();
        return ResponseEntity.ok(out);
    }

    // READ - by id
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(p -> ResponseEntity.ok(ProdutoMapper.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id,
                                                @RequestBody @Valid ProdutoDTO dto) {
        return service.buscar(id).map(existing -> {
            existing.setNome(dto.nome());
            existing.setPreco(dto.preco());
            // Se sua entidade tiver 'descricao', inclua no DTO e no Mapper, e descomente:
            // existing.setDescricao(dto.descricao());
            Produto saved = service.salvar(existing);
            return ResponseEntity.ok(ProdutoMapper.toDTO(saved));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscar(id).isEmpty()) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

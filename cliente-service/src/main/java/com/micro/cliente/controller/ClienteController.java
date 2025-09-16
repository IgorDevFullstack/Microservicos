package com.micro.cliente.controller;

import com.micro.cliente.dto.ClienteDTO;
import com.micro.cliente.mapper.ClienteMapper;
import com.micro.cliente.model.Cliente;
import com.micro.cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteDTO dto) {
        Cliente entity = ClienteMapper.toEntity(dto);
        Cliente saved  = service.salvar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteMapper.toDTO(saved));
    }

    // READ - list
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        List<ClienteDTO> out = service.listar()
                .stream().map(ClienteMapper::toDTO).toList();
        return ResponseEntity.ok(out);
    }

    // READ - by id
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(c -> ResponseEntity.ok(ClienteMapper.toDTO(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id,
                                                @RequestBody @Valid ClienteDTO dto) {
        return service.buscar(id).map(existing -> {
            existing.setNome(dto.nome());
            existing.setEmail(dto.email());
            existing.setTelefone(dto.telefone());
            Cliente saved = service.salvar(existing);
            return ResponseEntity.ok(ClienteMapper.toDTO(saved));
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

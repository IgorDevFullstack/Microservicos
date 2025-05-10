package com.micro.cliente.controller;
import com.micro.cliente.model.Cliente;
import com.micro.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente c) { return service.salvar(c); }

    @GetMapping
    public List<Cliente> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return service.buscar(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente c) {
        return service.buscar(id).map(cliente -> {
            cliente.setNome(c.getNome());
            cliente.setEmail(c.getEmail());
            cliente.setTelefone(c.getTelefone());
            return ResponseEntity.ok(service.salvar(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

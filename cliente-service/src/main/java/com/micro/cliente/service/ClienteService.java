package com.micro.cliente.service;
import com.micro.cliente.model.Cliente;
import com.micro.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente salvar(Cliente c) { return repo.save(c); }
    public List<Cliente> listar() { return repo.findAll(); }
    public Optional<Cliente> buscar(Long id) { return repo.findById(id); }
    public void deletar(Long id) { repo.deleteById(id); }
}
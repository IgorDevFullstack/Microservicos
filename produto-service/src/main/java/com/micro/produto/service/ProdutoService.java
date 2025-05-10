package com.micro.produto.service;
import com.micro.produto.model.Produto;
import com.micro.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    public Produto salvar(Produto c) { return repo.save(c); }
    public List<Produto> listar() { return repo.findAll(); }
    public Optional<Produto> buscar(Long id) { return repo.findById(id); }
    public void deletar(Long id) { repo.deleteById(id); }
}

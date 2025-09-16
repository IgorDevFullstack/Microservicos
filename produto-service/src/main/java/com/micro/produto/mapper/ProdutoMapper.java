package com.micro.produto.mapper;

import com.micro.produto.dto.ProdutoDTO;
import com.micro.produto.model.Produto;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(Produto p) {
        return new ProdutoDTO(
            p.getId(),
            p.getNome(),
            p.getPreco(),
            p.getDescricao()
        );
    }

    public static Produto toEntity(ProdutoDTO dto) {
        Produto p = new Produto();
        p.setId(dto.id());
        p.setNome(dto.nome());
        p.setPreco(dto.preco());
        p.setDescricao(dto.descricao());
        return p;
    }
}

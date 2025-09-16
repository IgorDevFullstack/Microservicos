package com.micro.produto.dto;

import jakarta.validation.constraints.*;

public record ProdutoDTO(
    Long id,
    @NotBlank @Size(max = 120) String nome,
    @NotNull Double preco,
    String descricao
) {}

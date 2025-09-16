package com.micro.cliente.dto;

import jakarta.validation.constraints.*;

public record ClienteDTO(
    Long id,
    @NotBlank @Size(max=120) String nome,
    @NotBlank @Email @Size(max=160) String email,
    @Size(max=20) String telefone
) {}


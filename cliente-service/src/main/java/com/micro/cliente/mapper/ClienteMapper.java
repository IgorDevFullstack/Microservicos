package com.micro.cliente.mapper;

import com.micro.cliente.dto.ClienteDTO;
import com.micro.cliente.model.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente c) {
        return new ClienteDTO(
            c.getId(),
            c.getNome(),
            c.getEmail(),
            c.getTelefone()
        );
    }

    public static Cliente toEntity(ClienteDTO dto) {
        Cliente c = new Cliente();
        c.setId(dto.id());
        c.setNome(dto.nome());
        c.setEmail(dto.email());
        c.setTelefone(dto.telefone());
        return c;
    }
}

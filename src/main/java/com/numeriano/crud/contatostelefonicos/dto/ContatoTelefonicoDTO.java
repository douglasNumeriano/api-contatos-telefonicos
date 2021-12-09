package com.numeriano.crud.contatostelefonicos.dto;

import com.numeriano.crud.contatostelefonicos.model.ContatoTelefonico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoTelefonicoDTO {

    private Long id;

    @Valid
    @NotEmpty
    private String nome;

    @Valid
    @NotEmpty
    private String telefone;

    @Valid
    @NotEmpty
    private String email;

    @Valid
    @NotEmpty
    private String tipoContato;

    public ContatoTelefonicoDTO(ContatoTelefonico contatoTelefonico){
        this.id = contatoTelefonico.getId();
        this.nome = contatoTelefonico.getNome();
        this.telefone = contatoTelefonico.getTelefone();
        this.email = contatoTelefonico.getEmail();
        this.tipoContato = contatoTelefonico.getTipoContato();
    }
}

package com.numeriano.crud.contatostelefonicos.model;

import com.numeriano.crud.contatostelefonicos.dto.ContatoTelefonicoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoTelefonico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tipoContato;

    public ContatoTelefonico(ContatoTelefonicoDTO contatoTelefonicoDTO){
        this.id = contatoTelefonicoDTO.getId();
        this.nome = contatoTelefonicoDTO.getNome();
        this.telefone = contatoTelefonicoDTO.getTelefone();
        this.email = contatoTelefonicoDTO.getEmail();
        this.tipoContato = contatoTelefonicoDTO.getTipoContato();
    }
}

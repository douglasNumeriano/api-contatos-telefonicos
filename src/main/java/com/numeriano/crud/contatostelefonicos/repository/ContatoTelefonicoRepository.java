package com.numeriano.crud.contatostelefonicos.repository;

import com.numeriano.crud.contatostelefonicos.model.ContatoTelefonico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoTelefonicoRepository extends JpaRepository<ContatoTelefonico, Long> {
}

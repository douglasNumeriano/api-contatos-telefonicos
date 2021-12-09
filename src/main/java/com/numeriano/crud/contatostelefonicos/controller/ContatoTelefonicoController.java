package com.numeriano.crud.contatostelefonicos.controller;

import com.numeriano.crud.contatostelefonicos.dto.ContatoTelefonicoDTO;
import com.numeriano.crud.contatostelefonicos.dto.MessageResponseDTO;
import com.numeriano.crud.contatostelefonicos.exception.ContatoTelefonicoException;
import com.numeriano.crud.contatostelefonicos.service.ContatoTelefonicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoTelefonicoController {

    @Autowired
    private ContatoTelefonicoService contatoTelefonicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ContatoTelefonicoDTO>> listAll(){
        List<ContatoTelefonicoDTO> contatoTelefonicoDTOList = contatoTelefonicoService.listAll();
        return ResponseEntity.ok(contatoTelefonicoDTOList);
    }

    @GetMapping("/get/{id}")
    public ContatoTelefonicoDTO findById(@PathVariable Long id){
        return contatoTelefonicoService.findById(id);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> createContatoTelefonico(@RequestBody @Valid ContatoTelefonicoDTO contatoTelefonicoDTO){
        try{
            return new ResponseEntity<>(contatoTelefonicoService.createContatoTelefonico(contatoTelefonicoDTO), HttpStatus.CREATED);
        }
        catch(ContatoTelefonicoException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/atualizar/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,
                                         @RequestBody @Valid ContatoTelefonicoDTO contatoTelefonicoDTO)
            throws ContatoTelefonicoException{
        return contatoTelefonicoService.updateById(id, contatoTelefonicoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        contatoTelefonicoService.delete(id);
    }
}

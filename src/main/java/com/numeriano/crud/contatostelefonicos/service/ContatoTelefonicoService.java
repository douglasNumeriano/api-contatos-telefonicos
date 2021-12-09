package com.numeriano.crud.contatostelefonicos.service;

import com.numeriano.crud.contatostelefonicos.dto.ContatoTelefonicoDTO;
import com.numeriano.crud.contatostelefonicos.dto.MessageResponseDTO;
import com.numeriano.crud.contatostelefonicos.exception.ContatoTelefonicoException;
import com.numeriano.crud.contatostelefonicos.model.ContatoTelefonico;
import com.numeriano.crud.contatostelefonicos.repository.ContatoTelefonicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoTelefonicoService {

    @Autowired
    private ContatoTelefonicoRepository contatoTelefonicoRepository;

    @Transactional(readOnly = true)
    public List<ContatoTelefonicoDTO> listAll(){
        List<ContatoTelefonico> contatoTelefonicoList = contatoTelefonicoRepository.findAll();
        return contatoTelefonicoList.stream().map(contatoTelefonico -> new ContatoTelefonicoDTO(contatoTelefonico)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContatoTelefonicoDTO findById(Long id){
        ContatoTelefonico contatoTelefonico = contatoTelefonicoRepository.getById(id);
        return new ContatoTelefonicoDTO(contatoTelefonico);
    }

    public MessageResponseDTO createContatoTelefonico(ContatoTelefonicoDTO contatoTelefonicoDTO) throws ContatoTelefonicoException{

        ContatoTelefonico contatoTelefonicoSave = new ContatoTelefonico(contatoTelefonicoDTO);
        ContatoTelefonico contatoTelefonico = contatoTelefonicoRepository.save(contatoTelefonicoSave);
        return MessageResponseDTO
                .builder()
                .message("Contato criado com sucesso ")
                .build();
    }

    public MessageResponseDTO updateById(Long id, ContatoTelefonicoDTO contatoTelefonicoDTO) throws ContatoTelefonicoException{

        verifyIfExists(id);
        ContatoTelefonico contatoTelefonicoUpdate = new ContatoTelefonico(contatoTelefonicoDTO);
        ContatoTelefonico contatoTelefonico = contatoTelefonicoRepository.save(contatoTelefonicoUpdate);
        return MessageResponseDTO
                .builder()
                .message("Contato " + contatoTelefonico.getId() + " atualizado com sucesso")
                .build();
    }

    public void delete(Long id){
        contatoTelefonicoRepository.deleteById(id);
    }

    private ContatoTelefonico verifyIfExists(Long id) throws ContatoTelefonicoException {
        return contatoTelefonicoRepository.findById(id)
                .orElseThrow(() -> new ContatoTelefonicoException("Este contato não foi encontrado"));
    }


}

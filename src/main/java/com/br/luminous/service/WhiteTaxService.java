package com.br.luminous.service;

import com.br.luminous.DTO.WhiteTaxDTO;
import com.br.luminous.mapper.WhiteTaxToWhiteTaxDTO;
import com.br.luminous.repository.WhiteTaxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhiteTaxService {
    private final WhiteTaxRepository whiteTaxRepository;
    private final WhiteTaxToWhiteTaxDTO whiteTaxMapper;

    public List<WhiteTaxDTO> getAll() {
        return whiteTaxMapper.mapper(whiteTaxRepository.findAll());
    }
}

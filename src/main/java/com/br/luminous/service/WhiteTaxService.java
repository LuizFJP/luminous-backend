package com.br.luminous.service;

import com.br.luminous.DTO.WhiteTaxDTO;
import com.br.luminous.entity.WhiteTax;
import com.br.luminous.repository.WhiteTaxRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WhiteTaxService {
    private final WhiteTaxRepository whiteTaxRepository;

    public List<WhiteTax> getAll() {
        return whiteTaxRepository.findAll();
    }
}

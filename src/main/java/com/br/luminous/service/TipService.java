package com.br.luminous.service;

import com.br.luminous.entity.Tip;
import com.br.luminous.exceptions.TipNotFoundException;
import com.br.luminous.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TipService {
    TipRepository tipRepository;
    public Tip getTip(Long id) {
        Optional<Tip> response = tipRepository.findById(id);
        return response.orElseThrow(TipNotFoundException::new);
    }
}

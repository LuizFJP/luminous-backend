package com.br.luminous.service;

import com.br.luminous.entity.Tip;
import com.br.luminous.exceptions.TipNotFoundException;
import com.br.luminous.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TipService {
    TipRepository tipRepository;

    public Long create(Tip tip){
        var tipResponse = tipRepository.save(tip);
        return tipResponse.getId();
    }
    public Tip getTip(Long id) {
        Optional<Tip> response = tipRepository.findById(id);
        return response.orElseThrow(TipNotFoundException::new);
    }

    public Tip update(Long id,String message){
        var tipToUpdate = tipRepository.findById(id);
        tipToUpdate.get().setMessage(message);
        var updatedTip = tipRepository.save(tipToUpdate.get());
        return updatedTip;
    }

    public void delete(Long id){
        try{
            tipRepository.deleteById(id);
        }catch(TipNotFoundException exception){
            exception.getMessage();
        }
    }
}

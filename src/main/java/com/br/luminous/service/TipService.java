package com.br.luminous.service;

import com.br.luminous.entity.Tip;
import com.br.luminous.exceptions.TipNotFoundException;
import com.br.luminous.models.TipRequest;
import com.br.luminous.repository.TipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TipService {
    private TipRepository tipRepository;

    public Long create(Tip tip){
        var tipResponse = tipRepository.save(tip);
        return tipResponse.getId();
    }
    public Tip getTip(Long id) {
        Optional<Tip> response = tipRepository.findById(id);
        return response.orElseThrow(TipNotFoundException::new);
    }

    public Tip update(Long id, TipRequest tipRequest){
        var tipToUpdate = tipRepository.findById(id).get();
        tipToUpdate.setTipMessage(tipRequest.getTipMessage());
        tipToUpdate.setTipTitle(tipRequest.getTipTitle());
        var updatedTip = tipRepository.save(tipToUpdate);
        return updatedTip;
    }

    public void delete(Long id){
        try{
            tipRepository.deleteById(id);
        }catch(TipNotFoundException exception){
            exception.getMessage();
        }
    }
    public List<Tip> getAll(){
        List<Tip> tipList = tipRepository.findAll();
        return tipList;
    }
}

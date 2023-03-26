package com.br.luminous.service;

import com.br.luminous.entity.Residence;
import com.br.luminous.repository.ResidenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResidenceService {

    private ResidenceRepository residenceRepository;

    public Long create(Residence residence){
        Residence response = residenceRepository.save(residence);
        return response.getId();
    }

}

package com.br.luminous.service;

import com.br.luminous.mapper.EnergyProvReqToEnergyProvEnt;
import com.br.luminous.models.EnergyProviderRequest;
import com.br.luminous.models.EnergyProviderResponse;
import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.exceptions.EnergyProviderNotFoundException;
import com.br.luminous.repository.EnergyProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnergyProviderService {

    private EnergyProviderRepository energyProviderRepository;
    private EnergyProvReqToEnergyProvEnt energyProvReqToEnergyProvEnt;

    public Long create(EnergyProviderRequest energyProviderRequest){
        var energyProvider = energyProvReqToEnergyProvEnt.mapper(energyProviderRequest);
        EnergyProvider response = energyProviderRepository.save(energyProvider);
        return response.getId();
    }

    public EnergyProvider getEnergyProviderById(Long id){
        Optional<EnergyProvider> EnergyProvider = energyProviderRepository.findById(id);
        return EnergyProvider.orElseThrow(EnergyProviderNotFoundException::new);
    }

    public EnergyProvider getEnergyProviderByName(String name){
        Optional<EnergyProvider> energyProvider = energyProviderRepository.findByCompanyName(name);
        return energyProvider.orElseThrow(EnergyProviderNotFoundException::new);
    }


    public EnergyProviderResponse get(String name){
        try {
            var energyProvider = getEnergyProviderByName(name);
            var energyProviderResponse = new EnergyProviderResponse();
            BeanUtils.copyProperties(energyProvider, energyProviderResponse);
            return energyProviderResponse;
        } catch (RuntimeException notFoundException){
            throw new EnergyProviderNotFoundException();
        }
    }

    public EnergyProviderResponse update(Long id, EnergyProviderRequest energyProviderRequest) {
        try {
            EnergyProvider energyProvider = getEnergyProviderById(id);
            BeanUtils.copyProperties(energyProviderRequest, energyProvider);
            energyProvider.setCompanyName(energyProviderRequest.getName());
            energyProvider.setUrlMaintenance(energyProviderRequest.getUrlMaintenance());
            energyProvider.setUrlEnergyFall(energyProviderRequest.getUrlEnergyFall());
            energyProviderRepository.save(energyProvider);
            var EnergyProviderResponse = new EnergyProviderResponse();
            BeanUtils.copyProperties(energyProvider, EnergyProviderResponse);
            return EnergyProviderResponse;
        } catch (RuntimeException notFoundException) {
            throw new EnergyProviderNotFoundException();
        }
    }



    public void delete(Long id) {
        try {
            getEnergyProviderById(id);
            energyProviderRepository.deleteById(id);
        } catch (RuntimeException notFoundException) {
            throw new EnergyProviderNotFoundException();
        }

    }

}

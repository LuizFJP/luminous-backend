package com.br.luminous.service;

import com.br.luminous.entity.TariffFlag;
import com.br.luminous.models.TariffFlagResponse;
import com.br.luminous.repository.TariffFlagRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TariffFlagService {

    private TariffFlagRepository tariffFlagRepository;

    public TariffFlagResponse getCurrentTariffFlag(){
        List<TariffFlag> tariffFlags = tariffFlagRepository.findAll();
        TariffFlag currentTariffFlag = tariffFlags.get(tariffFlags.size() - 1);

        LocalDate month = currentTariffFlag.getMonth();
        int flagType = currentTariffFlag.getFlagType();

        return new TariffFlagResponse(month, flagType);
    }
}

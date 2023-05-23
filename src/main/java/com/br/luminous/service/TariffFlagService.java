package com.br.luminous.service;

import com.br.luminous.entity.TariffFlag;
import com.br.luminous.models.TariffFlagResponse;
import com.br.luminous.repository.TariffFlagRepository;
import com.br.luminous.rest.tariffFlag.Items;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class TariffFlagService {

    private TariffFlagRepository tariffFlagRepository;
    private final String uri = "https://apise.way2.com.br/v1/bandeiras?apikey=d8f59e95abdb41d0ba053a178e21d403";

    public TariffFlagResponse getCurrentTariffFlag(){
        List<TariffFlag> tariffFlags = tariffFlagRepository.findAll();
        TariffFlag currentTariffFlag = tariffFlags.get(tariffFlags.size() - 1);

        LocalDate month = currentTariffFlag.getMonth();
        int flagType = currentTariffFlag.getFlagType();

        return new TariffFlagResponse(month, flagType);
    }

    //cron = segundo minuto hora dia mês dia_da_semana
    @Scheduled(cron = "0 1 0 1 * *")
    private void renewTariffFlag(){
        String datainicial = LocalDate.now().minusMonths(1).toString();
        String datafinal = LocalDate.now().toString();
        String URL = uri + String.format("&datainicial=%s&datafinal=%s", datainicial, datafinal);

        consumeTariffFlag(URL);
    }

    private void consumeTariffFlag(String URL){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Items> response = restTemplate.getForEntity(URL, Items.class);

        TariffFlag tariffFlag = new TariffFlag();
        tariffFlag.setFlagType(response.getBody().getItems().get(0).getFlagType());
        tariffFlag.setMonth(response.getBody().getItems().get(0).getMonth().toLocalDate());

        tariffFlagRepository.save(tariffFlag);
    }
}

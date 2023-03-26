package com.br.luminous.mapper;

import com.br.luminous.DTO.WhiteTaxDTO;
import com.br.luminous.entity.WhiteTax;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WhiteTaxToWhiteTaxDTO {
    public List<WhiteTaxDTO> mapper(List<WhiteTax> whiteTaxes) {
        List<WhiteTaxDTO> whiteTaxesDTO = new ArrayList<>();
        for (int i = 0; i < whiteTaxes.size(); i++) {
            var whiteTaxDTO = new WhiteTaxDTO();
            BeanUtils.copyProperties(whiteTaxes.get(i), whiteTaxDTO);
            var save = whiteTaxDTO.getRegularPrice() - whiteTaxDTO.getLowPrice();
            whiteTaxDTO.setSave((float) (Math.floor(save * 100) / 100));
            whiteTaxesDTO.add(whiteTaxDTO);
        }

        return whiteTaxesDTO;
    }
}

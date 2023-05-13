package com.br.luminous.service;

import com.br.luminous.models.DealershipRequest;
import com.br.luminous.models.DealershipResponse;
import com.br.luminous.entity.Dealership;
import com.br.luminous.exceptions.DealershipNotFoundException;
import com.br.luminous.repository.DealershipRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class DealershipService {

    private DealershipRepository dealershipRepository;
    private DealershipService dealershipService;


    public Long create(Dealership dealership){
        Dealership response = dealershipRepository.save(dealership);
        return response.getId();
    }


    public Dealership getDealershipById(Long id){
        Optional<Dealership> dealership = dealershipRepository.findById(id);
        return dealership.orElseThrow(DealershipNotFoundException::new);
    }


    public DealershipResponse get(Long id) {
        try {
            var dealership = getDealershipById(id);
            var dealershipResponse = new DealershipResponse();
            BeanUtils.copyProperties(dealership, dealershipResponse);
            return dealershipResponse;
        } catch (RuntimeException notFoundException) {
            throw new DealershipNotFoundException();
        }
    }


    public DealershipResponse update(Long id, DealershipRequest dealershipRequest) {
        try {
            Dealership dealership = getDealershipById(id);
            BeanUtils.copyProperties(dealershipRequest, dealership);
            dealership.setName(dealershipRequest.getName());
            dealership.setUrlMaintain(dealershipRequest.getUrlMantain());
            dealership.setUrlEnergyFall(dealershipRequest.getUrlEnergyFall());
            dealershipRepository.save(dealership);
            var dealershipResponse = new DealershipResponse();
            BeanUtils.copyProperties(dealership, dealershipResponse);
            return dealershipResponse;
        } catch (RuntimeException notFoundException) {
            throw new DealershipNotFoundException();
        }
    }



    public void delete(Long id) {
        try {
            getDealershipById(id);
            dealershipRepository.deleteById(id);
        } catch (RuntimeException notFoundException) {
            throw new DealershipNotFoundException();
        }

    }

}

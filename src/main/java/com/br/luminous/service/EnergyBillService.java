package com.br.luminous.service;

import com.br.luminous.entity.Address;
import com.br.luminous.entity.EnergyBill;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.mapper.EnergyBillRequestToEntity;
import com.br.luminous.mapper.EnergyBillToResponse;
import com.br.luminous.models.EnergyBillRequest;
import com.br.luminous.models.EnergyBillResponse;
import com.br.luminous.repository.EnergyBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class EnergyBillService {
    private EnergyBillRepository energyBillRepository;
    private AddressService addressService;
    private BillFileService billFileService;
    private EnergyBillRequestToEntity energyBillRequestToEntity;
    private EnergyBillToResponse energyBillToResponse;


    public Long create(Long address_id, Long billFile_id, EnergyBillRequest energyBillRequest) {
        var address = addressService.getAddressById(address_id);
        var billFile = billFileService.getById(billFile_id);
        EnergyBill energyBill =  energyBillRequestToEntity.mapper(energyBillRequest);
        energyBill.setAddress(address);
        energyBill.setBillFile(billFile);
        List<EnergyBill> energyBillList = address.getEnergyBills();
        energyBillList.add(energyBill);
        address.setEnergyBills(energyBillList);
        var energyBillPersisted = energyBillRepository.save(energyBill);
        return energyBillPersisted.getId();
    }

    public EnergyBillResponse getById(Long id) {
        Optional<EnergyBill> energyBill = energyBillRepository.findById(id);
        if(energyBill.isEmpty()){
            throw new EnergyBillNotFoundException();
        }
        EnergyBillResponse response = energyBillToResponse.mapper(energyBill.get());
        return response;
    }
    public List<EnergyBillResponse> getAll(Long addressId){
        var bills = energyBillRepository.findAllEnergyBillByAddress(addressId);
        List<EnergyBillResponse> energyBillResponseList = new ArrayList<>();
        for(EnergyBill energyBill: bills){
            EnergyBillResponse response = energyBillToResponse.mapper(energyBill);
            energyBillResponseList.add(response);
        }
        return energyBillResponseList;
    }

}

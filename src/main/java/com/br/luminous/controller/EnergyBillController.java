package com.br.luminous.controller;


import com.br.luminous.models.EnergyBillRequest;
import com.br.luminous.models.EnergyBillResponse;
import com.br.luminous.service.EnergyBillService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/energyBill")
public class EnergyBillController {
    private EnergyBillService energyBillService;

    @GetMapping("/{id}")
    public ResponseEntity<EnergyBillResponse> getEnergyBillById(@PathVariable Long id){
        EnergyBillResponse energyBillResponse = energyBillService.getById(id);
        return new ResponseEntity<EnergyBillResponse>(energyBillResponse, HttpStatus.OK);
    }
        @PostMapping("/address/{address_id}/billFile/{billFile_id}")
    public ResponseEntity<Long> createEnergyBill(@PathVariable Long address_id,@PathVariable Long billFile_id,@RequestBody EnergyBillRequest energyBillRequest){
            Long id = energyBillService.create(address_id, billFile_id, energyBillRequest);
            return new ResponseEntity<Long>(id, HttpStatus.CREATED);
        }
        @GetMapping("/getAll/{address_id}")
    public ResponseEntity<List<EnergyBillResponse>> getAll(@PathVariable Long address_id){
        var response = energyBillService.getAll(address_id);
        return new ResponseEntity<List<EnergyBillResponse>>(
                response, HttpStatus.OK);
        }
        @PutMapping("/update/{id}")
    public ResponseEntity<EnergyBillResponse> update(@PathVariable Long id, @RequestBody EnergyBillRequest energyBillRequest){
            var response = energyBillService.update(id, energyBillRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        @DeleteMapping("/delete/{id}")
    public ResponseEntity<EnergyBillResponse> delete(@PathVariable Long id){
            energyBillService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }

}

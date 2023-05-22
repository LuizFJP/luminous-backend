package com.br.luminous.controller;


import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.exceptions.BillFileNotFoundException;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.models.ApiResponse;
import com.br.luminous.models.EnergyBillRequest;
import com.br.luminous.models.EnergyBillResponse;
import com.br.luminous.service.ApiResponseService;
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

    private ApiResponseService apiResponseService;
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EnergyBillResponse>> getEnergyBillById(@PathVariable Long id) {
        try {
            EnergyBillResponse energyBillResponse = energyBillService.getById(id);
            ApiResponse<EnergyBillResponse> response = apiResponseService.createSuccessResponse(energyBillResponse, "Energy bill for id: "+ id + "was successfully returned");
            return ResponseEntity.ok(response);
        } catch (EnergyBillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Energy Bill was not found for id: " + id));
        }
    }

    @PostMapping("/address/{address_id}/billFile/{billFile_id}")
    public ResponseEntity<ApiResponse<Long>> createEnergyBill(@PathVariable Long address_id, @PathVariable Long billFile_id, @RequestBody EnergyBillRequest energyBillRequest) {
        try {
            Long id = energyBillService.create(address_id, billFile_id, energyBillRequest);
            ApiResponse<Long> response = apiResponseService.createSuccessResponse(id, "Energy Bill was created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AddressNotFoundException | BillFileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse(e.getMessage()));
        }
    }

    @GetMapping("/getAll/{address_id}")
    public ResponseEntity<ApiResponse<List<EnergyBillResponse>>> getAll(@PathVariable Long address_id) {
        try {
            List<EnergyBillResponse> response = energyBillService.getAll(address_id);
            ApiResponse<List<EnergyBillResponse>> apiResponse = apiResponseService.createSuccessResponse(response, "All Energy Bill for Address id: " + address_id + " was successfully returned");
            return ResponseEntity.ok(apiResponse);
        }catch(AddressNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EnergyBillResponse>> update(@PathVariable Long id, @RequestBody EnergyBillRequest energyBillRequest) {
        try {
            EnergyBillResponse response = energyBillService.update(id, energyBillRequest);
            ApiResponse<EnergyBillResponse> apiResponse = apiResponseService.createSuccessResponse(response, "Energy Bill for id: " + id + " was successfully updated");
            return ResponseEntity.ok(apiResponse);
        } catch (EnergyBillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Energy Bill was not found for id: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        try {
            energyBillService.delete(id);
            ApiResponse<Void> response = apiResponseService.createSuccessResponse(null, "Energy bill for id: " + id + " was successfully deleted");
            return ResponseEntity.ok(response);
        }catch(EnergyBillNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse(e.getMessage()));
        }
    }

}

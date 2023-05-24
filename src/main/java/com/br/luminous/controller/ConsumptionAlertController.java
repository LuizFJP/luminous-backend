package com.br.luminous.controller;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.exceptions.ConsumptionAlertNotFound;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.models.ApiResponse;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.service.ApiResponseService;
import com.br.luminous.service.ConsumptionAlertService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consumption-alert")
public class ConsumptionAlertController {
    ConsumptionAlertService consumptionAlertService;

    ApiResponseService apiResponseService;
    @PostMapping("/address/{id}")
    public ResponseEntity<ApiResponse<Long>> create(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest) {
        try {
            Long consumptionAlertId = consumptionAlertService.create(id, consumptionAlertRequest);
            ApiResponse<Long> response = apiResponseService.createSuccessResponse(consumptionAlertId, "Consumption Alert was successfully created");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AddressNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("User was not found for id: " + id));
        }catch(IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(apiResponseService.createErrorResponse(exception.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ConsumptionAlert>> update(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest) {
        try {
            ConsumptionAlert updatedAlert = consumptionAlertService.update(id, consumptionAlertRequest);
            ApiResponse<ConsumptionAlert> response = apiResponseService.createSuccessResponse(updatedAlert, "Consumption Alert was successfully updated");
            return ResponseEntity.ok(response);
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Consumption Alert was not found for id: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        try {
            consumptionAlertService.delete(id);
            ApiResponse<Void> response = apiResponseService.createSuccessResponse(null, "Consumption Alert for id: " + id + "was successfully deleted");
            return ResponseEntity.ok(response);
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Consumption Alert was not found for id: " + id));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ConsumptionAlert>> get(@PathVariable Long id) {
        try {
            ConsumptionAlert response = consumptionAlertService.get(id);
            ApiResponse<ConsumptionAlert> apiResponse = apiResponseService.createSuccessResponse(response, "Consumption Alert with id: " + id + "was successfully returned");
            return ResponseEntity.ok(apiResponse);
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Consumption Alert was not found for id: " + id));
        }
    }

    @GetMapping("/getAll/address/{id}")
    public ResponseEntity<ApiResponse<List<ConsumptionAlert>>> getAll(@PathVariable Long id) {
        try {
            List<ConsumptionAlert> response = consumptionAlertService.getAll(id);
                return ResponseEntity.ok(apiResponseService.createSuccessResponse(response, "All Consumption Alerts from user " + id + " were returned"));
        } catch (UserNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponseService.createErrorResponse("Consumption Alerts not found for user: " + id));
        }
    }
}

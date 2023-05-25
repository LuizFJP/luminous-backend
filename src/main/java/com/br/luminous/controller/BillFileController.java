package com.br.luminous.controller;

import com.br.luminous.entity.BillFile;
import com.br.luminous.models.ApiResponse;
import com.br.luminous.service.ApiResponseService;
import com.br.luminous.service.BillFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/billFile")
public class BillFileController {
    private BillFileService billFileService;
    private ApiResponseService apiResponseService;
    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<Long>> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            Long id = billFileService.uploadBillFile(file);
            ApiResponse<Long> response = apiResponseService.createSuccessResponse(id, "File was successfully uploaded");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponseService.createErrorResponse("Error uploading file."));
        }
    }

}

package com.br.luminous.controller;

import com.br.luminous.service.BillFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/billFile")
public class BillFileController {
    private final BillFileService billFileService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(MultipartFile file) {
        try {
            Long id = billFileService.uploadBillFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body("File was successfully uploaded with ID: " + id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        }
    }
}

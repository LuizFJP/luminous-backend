package com.br.luminous.controller;

import com.br.luminous.entity.BillFile;
import com.br.luminous.service.BillFileService;
import lombok.AllArgsConstructor;
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
    @PostMapping("/upload")
    public ResponseEntity<BillFile> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        BillFile billFile = billFileService.uploadBillFile(file);
        return ResponseEntity.ok(billFile);
    }
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
//        String uploadedFilePath = BillFileService.upload(file);
//
//        return ResponseEntity.ok(uploadedFilePath);
//        }
}

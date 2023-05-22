package com.br.luminous.service;

import com.br.luminous.entity.BillFile;
import com.br.luminous.exceptions.BillFileNotFoundException;
import com.br.luminous.repository.BillFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BillFileService {
    private final Path root = Paths.get("uploads");
    private final BillFileRepository billFileRepository;
    public Long uploadBillFile(MultipartFile file) throws IOException {
        var unique = new Date().getTime() + Math.round(Math.floor(Math.random() * 1000000));
        String newFileName =  unique + "_" + file.getOriginalFilename();
        Path pathToFile = this.root.resolve(newFileName);
        Long fileSize = file.getSize();
        try{
            Files.createDirectories(root);
        }catch(IOException error){
            throw new RuntimeException("Pasta não encontrada");
        }
        try{
            Files.copy(file.getInputStream(), pathToFile);
        }catch(Exception error){
            throw new RuntimeException("Problemas em guardar seu arquivo");
        }
        BillFile billFile = new BillFile();
        billFile.setName(newFileName);
        billFile.setSize(fileSize);
        billFile.setUrl(pathToFile.toString());

        billFileRepository.save(billFile);
        return billFile.getId();
    }
    public BillFile getById(Long id){
        Optional<BillFile> billFile = billFileRepository.findById(id);
        return billFile.orElseThrow(BillFileNotFoundException::new);
    }
}

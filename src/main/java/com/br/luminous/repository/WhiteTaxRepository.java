package com.br.luminous.repository;

import com.br.luminous.entity.WhiteTax;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WhiteTaxRepository extends CrudRepository<WhiteTax, Long> {
    @Override
    List<WhiteTax> findAll();
}

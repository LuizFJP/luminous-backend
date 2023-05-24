package com.br.luminous.repository;

import com.br.luminous.entity.BillFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillFileRepository extends CrudRepository<BillFile, Long> {

}

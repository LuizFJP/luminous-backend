package com.br.luminous.repository;

import com.br.luminous.entity.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> { }

package com.br.luminous.repository;

import com.br.luminous.entity.Address;
import com.br.luminous.entity.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    Optional <List<Device>> findByAddressId(Long addressId);
}

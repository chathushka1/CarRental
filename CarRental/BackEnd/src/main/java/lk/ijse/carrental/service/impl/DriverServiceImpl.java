package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.entity.Customer;
import lk.ijse.carrental.entity.Driver;
import lk.ijse.carrental.repo.DriverRepo;
import lk.ijse.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 08:20
 * 2023-10-27
 * FrontEnd
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDId())) {
            driverRepo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException(dto.getDId() + "Driver Already Exists !!!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)) {
            driverRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return null;
    }

    @Override
    public DriverDTO findDriver(String id) {
        return null;
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDId())) {
            driverRepo.save(mapper.map(driverDTO, Driver.class));
        } else {
            throw new RuntimeException(driverDTO.getDId() + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public String generateDriverIds() {
        return null;
    }

    @Override
    public int countRegisteredDrivers() {
        return 0;
    }

    @Override
    public DriverDTO searchUserFromDriver(String id) {
        return null;
    }

    @Override
    public DriverDTO findDriverToReserve(String nic) {
        return null;
    }
}

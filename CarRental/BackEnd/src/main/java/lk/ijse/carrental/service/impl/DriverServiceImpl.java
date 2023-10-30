package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.entity.Driver;
import lk.ijse.carrental.repo.DriverRepo;
import lk.ijse.carrental.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all, new TypeToken<List<DriverDTO>>() {}.getType());
    }

    @Override
    public DriverDTO findDriver(String id) {
        if (driverRepo.existsById(id)) {
            Driver driver = driverRepo.findById(id).get();
            return mapper.map(driver, DriverDTO.class);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
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
        return driverRepo.generateDId();
    }

    @Override
    public int countRegisteredDrivers() {
        return driverRepo.registeredDriverCount();
    }

    @Override
    public DriverDTO searchUserFromDriver(String id) {
        Driver driver = driverRepo.searchDriver(id);
        return mapper.map(driver, DriverDTO.class);
    }

    @Override
    public DriverDTO findDriverToReserve(String nic) {
        return null;
    }
}

package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.service.DriverService;
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
    @Override
    public void addDriver(DriverDTO dto) {

    }

    @Override
    public void deleteDriver(String id) {

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
    public void updateDriver(DriverDTO c) {

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

package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.dto.DriverDTO;
import lk.ijse.carrental.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 19:36
 * 2023-10-29
 * FrontEnd
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Override
    public void addCar(CarDTO dto) {

    }

    @Override
    public void deleteCar(String id) {

    }

    @Override
    public List<CarDTO> getAllCar() {
        return null;
    }

    @Override
    public CarDTO findCar(String id) {
        return null;
    }

    @Override
    public void updateCar(CarDTO c) {

    }
}

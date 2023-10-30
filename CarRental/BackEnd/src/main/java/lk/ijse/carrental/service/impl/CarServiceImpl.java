package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getVId())) {
            carRepo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException(dto.getVId() + " Car Already Exists !!!");
        }
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

    @Override
    public String generateCarIds() {
        return null;
    }

    @Override
    public int countRegisteredCars() {
        return 0;
    }

    @Override
    public CarDTO searchUserFromCar(String id) {
        return null;
    }

    @Override
    public CarDTO findCarToReserve(String vNumber) {
        return null;
    }
}

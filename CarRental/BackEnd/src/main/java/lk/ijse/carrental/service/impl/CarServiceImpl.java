package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarDTO;
import lk.ijse.carrental.entity.Car;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.smartcardio.Card;
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
        if (!carRepo.existsById(dto.getCarId())) {
            carRepo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException(dto.getCarId() + " Car Already Exists !!!");
        }
    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all, new TypeToken<List<CarDTO>>() {}.getType());
    }

    @Override
    public CarDTO findCar(String id) {
        if (carRepo.existsById(id)) {
            Car car = carRepo.findById(id).get();
            return mapper.map(car, CarDTO.class);
        } else {
            throw new RuntimeException(id + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public void updateCar(CarDTO c) {
        if (carRepo.existsById(c.getCarId())) {
            carRepo.save(mapper.map(c, Car.class));
        } else {
            throw new RuntimeException(c.getCarId() + "No Please Check The Correct Id..!");
        }
    }

    @Override
    public String generateCarIds() {
        return carRepo.generateCarId();
    }

    @Override
    public int countRegisteredCars() {
        return carRepo.searchRegNumberIsExists();
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

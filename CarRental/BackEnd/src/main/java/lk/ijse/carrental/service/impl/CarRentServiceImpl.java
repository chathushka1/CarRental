package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CarRentDTO;
import lk.ijse.carrental.entity.CarRent;
import lk.ijse.carrental.repo.CarRepo;
import lk.ijse.carrental.service.CarRentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 20:03
 * 2023-10-31
 * FrontEnd
 */
public class CarRentServiceImpl implements CarRentService {


    @Override
    public void addCarRent(CarRentDTO dto) {

    }

    @Override
    public void updateCarRent(CarRentDTO dto) {

    }

    @Override
    public void deleteCarRent(String rentId) {

    }

    @Override
    public CarRentDTO searchCarRent(String rentId) {
        return null;
    }

    @Override
    public List<CarRentDTO> getAllCarRents() {
        return null;
    }

    @Override
    public String generateRentId() {
        return null;
    }

    @Override
    public void updateCarRentStatus(String rentId, String status) {

    }

    @Override
    public List<CarRentDTO> getCarRentsByStatus(String status) {
        return null;
    }

    @Override
    public List<CarRentDTO> getCarRentsByDrivingLicenceNo(String status, String licenceNo) {
        return null;
    }

    @Override
    public int getTodayBookingCount(String today) {
        return 0;
    }

    @Override
    public List<CarRentDTO> getTodayBookings(String today) {
        return null;
    }

    @Override
    public List<CarRentDTO> getCarRentsByCustomerId(String customerId) {
        return null;
    }
}

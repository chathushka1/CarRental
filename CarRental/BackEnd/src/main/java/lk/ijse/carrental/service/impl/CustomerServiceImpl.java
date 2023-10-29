package lk.ijse.carrental.service.impl;

import lk.ijse.carrental.dto.CustomerDTO;
import lk.ijse.carrental.service.CustomerService;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:57
 * 2023-10-25
 * FrontEnd
 */
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void addCustomer(CustomerDTO dto) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO c) {

    }

    @Override
    public int registeredCustomerCount() {
        return 0;
    }

    @Override
    public int dailyRegisteredCustomerCount(String date) {
        return 0;
    }

    @Override
    public CustomerDTO searchUserCustomer(String id) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerToReserve(String nic) {
        return null;
    }
}

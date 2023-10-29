package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.CustomerDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 22:51
 * 2023-10-25
 * FrontEnd
 */
public interface CustomerService {
    void addCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    List<CustomerDTO> getAllCustomer();
    CustomerDTO findCustomer(String id);
    void updateCustomer(CustomerDTO c);
    int registeredCustomerCount();
    int dailyRegisteredCustomerCount(String date);
    CustomerDTO searchUserCustomer(String id);
    CustomerDTO findCustomerToReserve(String nic);
}

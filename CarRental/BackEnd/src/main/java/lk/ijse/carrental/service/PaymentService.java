package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.PaymentDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:44
 * 2023-11-02
 * FrontEnd
 */
public interface PaymentService {
    void savePayment(PaymentDTO dto);

    void updatePayment(PaymentDTO dto);

    void deletePayment(String paymentId);

    PaymentDTO searchPayment(String paymentId);

    List<PaymentDTO> getAllPayments();

    List<PaymentDTO> getAllPaymentsByDateRange(String fromDate, String toDate);

    List<PaymentDTO> getAllPaymentsByCustomerId(String customerId);

    String generatePaymentId();

    void deletePaymentByRentId(String rentId);

    double calculatePaidPayments(String rentId);

    double getSumOfPaymentsByDateRange(String fromDate, String toDate);
}

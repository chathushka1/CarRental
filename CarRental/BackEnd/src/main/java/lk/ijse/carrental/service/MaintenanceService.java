package lk.ijse.carrental.service;

import lk.ijse.carrental.dto.MaintenanceDTO;

import java.util.List;

/**
 * `@authority` Chathushka Madumal
 * hp
 * 23:53
 * 2023-11-02
 * FrontEnd
 */
public interface MaintenanceService {
    void addMaintenance(MaintenanceDTO dto);

    void updateMaintenance(MaintenanceDTO dto);

    void deleteMaintenance(String maintenanceId);

    MaintenanceDTO searchMaintenance(String maintenanceId);

    List<MaintenanceDTO> getAllMaintenances();

    String generateMaintenanceId();

    void updateMaintenanceCost(String maintenanceId, double cost);

    List<MaintenanceDTO> getAllUnderMaintenances();

    List<MaintenanceDTO> getAllMaintenancesByDateRange(String fromDate, String toDate);

    double getSumOfMaintenanceAmount(String fromDate, String toDate);
}

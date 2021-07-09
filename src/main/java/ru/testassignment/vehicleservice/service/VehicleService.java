package ru.testassignment.vehicleservice.service;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Pdf;
import ru.testassignment.vehicleservice.dto.Vehicle;

public interface VehicleService {

  List<Vehicle> findAllVehicles();

  List<Vehicle> findVehiclesByFields(Integer ownerId, Integer brandId, Integer modelId);

  int updateVehicle(Vehicle updateVehicle);

  Long createVehicle(Vehicle newVehicle);

  int deleteVehicle(Vehicle deleteVehicle);

  List<Pdf> pdfExport();
}

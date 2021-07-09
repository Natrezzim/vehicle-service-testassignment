package ru.testassignment.vehicleservice.repository;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Pdf;
import ru.testassignment.vehicleservice.dto.Vehicle;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Vehicles;

public interface VehicleRepository {

  List<Vehicles> findAllVehicles();

  List<Vehicles> findVehiclesByFields(Integer ownerId, Integer brandId, Integer modelId);

  int updateVehicle(Vehicle updateVehicle);

  Long createVehicle(Vehicle newVehicle);

  int deleteVehicle(Vehicle deleteVehicle);

  List<Pdf> pdfExport();

}

package ru.testassignment.vehicleservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testassignment.vehicleservice.dto.Pdf;
import ru.testassignment.vehicleservice.dto.Vehicle;
import ru.testassignment.vehicleservice.repository.VehicleRepository;
import ru.testassignment.vehicleservice.service.utility.ConverterService;

@Service
public class VehicleServiceImpl implements VehicleService {

  VehicleRepository vehicleRepository;

  ConverterService converterService;

  @Autowired
  public VehicleServiceImpl(
      VehicleRepository vehicleRepository, ConverterService converterService) {
    this.vehicleRepository = vehicleRepository;
    this.converterService = converterService;
  }

  @Override
  public List<Vehicle> findAllVehicles() {

    return vehicleRepository.findAllVehicles().stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public int updateVehicle(Vehicle updateVehicle) {
    return vehicleRepository.updateVehicle(updateVehicle);
  }

  @Override
  public Long createVehicle(Vehicle newVehicle) {
    return vehicleRepository.createVehicle(newVehicle);
  }

  @Override
  public int deleteVehicle(Vehicle deleteVehicle) {
    return vehicleRepository.deleteVehicle(deleteVehicle);
  }

  @Override
  public List<Pdf> pdfExport() {
    return vehicleRepository.pdfExport();
  }

  @Override
  public List<Vehicle> findVehiclesByFields(Integer ownerId, Integer brandId, Integer modelId) {
    return vehicleRepository.findVehiclesByFields(ownerId, brandId, modelId).stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }
}

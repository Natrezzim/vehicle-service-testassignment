package ru.testassignment.vehicleservice.service.utility;

import org.springframework.stereotype.Component;
import ru.testassignment.vehicleservice.dto.Brand;
import ru.testassignment.vehicleservice.dto.Model;
import ru.testassignment.vehicleservice.dto.Owner;
import ru.testassignment.vehicleservice.dto.Vehicle;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Brands;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Models;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Owners;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Vehicles;

@Component
public class ConverterService {

  public Vehicle convert(Vehicles vehicles) {
    return new Vehicle(
        vehicles.getId(),
        vehicles.getOwnerId(),
        vehicles.getBrandId(),
        vehicles.getModelId());
  }

  public Model convert(Models models) {
    return new Model(
        models.getId(), models.getName(), models.getCharacteristics(), models.getBrandId());
  }

  public Owner convert(Owners owners) {
    return new Owner(
        owners.getId(), owners.getLastName(), owners.getFirstName(), owners.getPatronymic());
  }

  public Brand convert(Brands brands) {
    return new Brand(brands.getId(), brands.getName());
  }
}

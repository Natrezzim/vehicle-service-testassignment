package ru.testassignment.vehicleservice.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicle {

  Long id;
  Integer ownerId;
  Integer brandId;
  Integer modelId;

  public Vehicle() {
  }

  public Vehicle(Long id, Integer ownerId, Integer brandId, Integer modelId) {
    this.id = id;
    this.ownerId = ownerId;
    this.brandId = brandId;
    this.modelId = modelId;
  }

}

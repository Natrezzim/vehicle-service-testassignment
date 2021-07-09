package ru.testassignment.vehicleservice.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Model {

  Integer id;
  String name;
  String characteristics;
  Integer brandId;

  public Model() {
  }

  public Model(Integer id, String name, String characteristics, Integer brandId) {
    this.id = id;
    this.name = name;
    this.characteristics = characteristics;
    this.brandId = brandId;
  }

}

package ru.testassignment.vehicleservice.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand {

  Integer id;
  String name;

  public Brand() {
  }

  public Brand(Integer id, String name) {
    this.id = id;
    this.name = name;
  }
}

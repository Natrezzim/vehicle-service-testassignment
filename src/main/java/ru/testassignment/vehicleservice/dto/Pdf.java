package ru.testassignment.vehicleservice.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pdf {

  Long id;
  String first_name;
  String last_name;
  String patronymic;
  String characteristics;
  String name;

  public Pdf() {

  }

}

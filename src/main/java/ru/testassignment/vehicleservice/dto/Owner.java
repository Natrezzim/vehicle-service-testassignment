package ru.testassignment.vehicleservice.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Owner {

  Integer id;
  String lastName;
  String firstName;
  String patronymic;

  public Owner() {
  }

  public Owner(Integer id, String lastName, String firstName, String patronymic) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.patronymic = patronymic;
  }

  public Owner(String lastName, String firstName, String patronymic) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.patronymic = patronymic;
  }
}

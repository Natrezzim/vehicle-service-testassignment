package ru.testassignment.vehicleservice.service;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Owner;

public interface OwnerService {

  List<Owner> findAllOwners();

  List<Owner> findOwnerByLastName(String lastName);

  int updateOwner(Owner updateOwner);

  int createOwner(Owner newOwner);

  int deleteOwner(Owner deleteOwner);

}

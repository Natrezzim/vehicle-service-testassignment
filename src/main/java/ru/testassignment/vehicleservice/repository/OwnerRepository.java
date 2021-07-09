package ru.testassignment.vehicleservice.repository;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Owner;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Owners;

public interface OwnerRepository {

  List<Owners> findAllOwners();

  int updateOwner(Owner updateOwner);

  int createOwner(Owner newOwner);

  int deleteOwner(Owner deleteOwner);

  List<Owners> findOwnerByLastName(String lastName);

}

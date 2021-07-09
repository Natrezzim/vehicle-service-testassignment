package ru.testassignment.vehicleservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.testassignment.vehicleservice.dto.Owner;
import ru.testassignment.vehicleservice.service.OwnerService;

@RestController
@RequestMapping(value = "/owners")
public class OwnerController {

  private final OwnerService ownerService;

  @Autowired
  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @GetMapping
  public List<Owner> findAllVehicles() {
    return ownerService.findAllOwners();
  }

  @GetMapping(value = "/")
  public List<Owner> findOwnerByLastName(@RequestParam String lastName) {
    return ownerService.findOwnerByLastName(lastName);
  }

  @PutMapping
  public int updateOwner(@RequestBody Owner updateOwner) {
    return ownerService.updateOwner(updateOwner);
  }

  @PostMapping()
  public int newOwner(@RequestBody Owner newOwner) {
    return ownerService.createOwner(newOwner);
  }

  @DeleteMapping
  public int deleteOwner(@RequestBody Owner deleteOwner) {
    return ownerService.deleteOwner(deleteOwner);
  }
}

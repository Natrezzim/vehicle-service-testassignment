package ru.testassignment.vehicleservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testassignment.vehicleservice.dto.Owner;
import ru.testassignment.vehicleservice.repository.OwnerRepository;
import ru.testassignment.vehicleservice.service.utility.ConverterService;

@Service
public class OwnerServiceImpl implements OwnerService {

  OwnerRepository ownerRepository;
  ConverterService converterService;

  @Autowired
  public OwnerServiceImpl(OwnerRepository ownerRepository, ConverterService converterService) {
    this.ownerRepository = ownerRepository;
    this.converterService = converterService;
  }

  @Override
  public List<Owner> findAllOwners() {
    return ownerRepository.findAllOwners().stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public List<Owner> findOwnerByLastName(String lastName) {
    return ownerRepository.findOwnerByLastName(lastName).stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public int updateOwner(Owner updateOwner) {

    return ownerRepository.updateOwner(updateOwner);
  }

  @Override
  public int createOwner(Owner newOwner) {
    return ownerRepository.createOwner(newOwner);
  }

  @Override
  public int deleteOwner(Owner deleteOwner) {
    return ownerRepository.deleteOwner(deleteOwner);
  }
}

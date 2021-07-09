package ru.testassignment.vehicleservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testassignment.vehicleservice.dto.Brand;
import ru.testassignment.vehicleservice.repository.BrandRepository;
import ru.testassignment.vehicleservice.service.utility.ConverterService;

@Service
public class BrandServiceImpl implements BrandService {

  BrandRepository brandRepository;
  ConverterService converterService;

  @Autowired
  public BrandServiceImpl(BrandRepository brandRepository, ConverterService converterService) {
    this.brandRepository = brandRepository;
    this.converterService = converterService;
  }

  @Override
  public List<Brand> findAllBrands() {
    return brandRepository.findAllBrands().stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public List<Brand> findBrandByName(String name) {
    return brandRepository.findBrandByName(name).stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public int updateBrand(Brand updateBrand) {
    return brandRepository.updateBrand(updateBrand);
  }

  @Override
  public int createBrand(Brand newBrand) {
    return brandRepository.createBrand(newBrand);

  }

  @Override
  public int deleteBrand(Brand deleteBrand) {
    return brandRepository.deleteBrand(deleteBrand);
  }
}

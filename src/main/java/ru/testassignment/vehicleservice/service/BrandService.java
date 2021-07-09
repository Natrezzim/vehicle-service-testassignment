package ru.testassignment.vehicleservice.service;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Brand;

public interface BrandService {

  List<Brand> findAllBrands();

  List<Brand> findBrandByName(String name);

  int updateBrand(Brand updateBrand);

  int createBrand(Brand newBrand);

  int deleteBrand(Brand deleteBrand);
}

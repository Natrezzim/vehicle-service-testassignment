package ru.testassignment.vehicleservice.repository;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Brand;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Brands;

public interface BrandRepository {

  List<Brands> findAllBrands();

  List<Brands> findBrandByName(String name);

  int updateBrand(Brand updateBrand);

  int createBrand(Brand newBrand);

  int deleteBrand(Brand deleteBrand);
}

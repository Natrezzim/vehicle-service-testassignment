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
import ru.testassignment.vehicleservice.dto.Brand;
import ru.testassignment.vehicleservice.service.BrandService;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

  private final BrandService brandService;

  @Autowired
  public BrandController(BrandService brandService) {
    this.brandService = brandService;
  }

  @GetMapping
  public List<Brand> findAllBrands() {
    return brandService.findAllBrands();
  }

  @GetMapping(value = "/")
  public List<Brand> findBrandByName(@RequestParam String name) {
    return brandService.findBrandByName(name);
  }

  @PutMapping
  public int updateBrand(@RequestBody Brand updateBrand) {
    return brandService.updateBrand(updateBrand);
  }

  @PostMapping()
  public int newBrand(@RequestBody Brand newBrand) {
    return brandService.createBrand(newBrand);
  }

  @DeleteMapping
  public int deleteBrand(@RequestBody Brand deleteBrand) {
    return brandService.deleteBrand(deleteBrand);
  }
}

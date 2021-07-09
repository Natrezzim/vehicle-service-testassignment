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
import ru.testassignment.vehicleservice.dto.Model;
import ru.testassignment.vehicleservice.service.ModelService;

@RestController
@RequestMapping(value = "/models")
public class ModelController {

  private final ModelService modelService;

  @Autowired
  public ModelController(ModelService modelService) {
    this.modelService = modelService;
  }

  @GetMapping
  public List<Model> findAllVehicles() {
    return modelService.findAllModels();
  }

  @GetMapping(value = "/")
  public List<Model> findModelByName(@RequestParam String name) {
    return modelService.findModelByName(name);
  }

  @PutMapping
  public int updateModel(Model updateModel) {
    return modelService.updateModel(updateModel);
  }

  @PostMapping()
  public int newModel(@RequestBody Model newModel) {
    return modelService.createModel(newModel);
  }

  @DeleteMapping
  public int deleteModel(@RequestBody Model deleteModel) {
    return modelService.deleteModel(deleteModel);
  }
}

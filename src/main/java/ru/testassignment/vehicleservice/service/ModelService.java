package ru.testassignment.vehicleservice.service;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Model;

public interface ModelService {

  List<Model> findAllModels();

  int updateModel(Model updateModel);

  int createModel(Model newModel);

  int deleteModel(Model deleteModel);

  List<Model> findModelByName(String name);
}

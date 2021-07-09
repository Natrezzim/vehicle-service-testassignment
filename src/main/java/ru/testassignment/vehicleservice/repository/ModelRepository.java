package ru.testassignment.vehicleservice.repository;

import java.util.List;
import ru.testassignment.vehicleservice.dto.Model;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Models;

public interface ModelRepository {

  List<Models> findAllModels();

  List<Models> findModelByName(String name);

  int updateModel(Model u);

  int createModel(Model newModel);

  int deleteModel(Model deleteModel);

}

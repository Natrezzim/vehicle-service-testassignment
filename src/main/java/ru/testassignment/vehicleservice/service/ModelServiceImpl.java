package ru.testassignment.vehicleservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testassignment.vehicleservice.dto.Model;
import ru.testassignment.vehicleservice.repository.ModelRepository;
import ru.testassignment.vehicleservice.service.utility.ConverterService;

@Service
public class ModelServiceImpl implements ModelService {

  ModelRepository modelRepository;

  ConverterService converterService;

  @Autowired
  public ModelServiceImpl(ModelRepository modelRepository, ConverterService converterService) {
    this.modelRepository = modelRepository;
    this.converterService = converterService;
  }

  @Override
  public List<Model> findAllModels() {
    return modelRepository.findAllModels().stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }

  @Override
  public int updateModel(Model updateModel) {

    return modelRepository.updateModel(updateModel);
  }

  @Override
  public int createModel(Model newModel) {
    return modelRepository.createModel(newModel);

  }

  @Override
  public int deleteModel(Model deleteModel) {
    return modelRepository.deleteModel(deleteModel);
  }

  @Override
  public List<Model> findModelByName(String name) {
    return modelRepository.findModelByName(name).stream()
        .map(pojo -> converterService.convert(pojo))
        .collect(Collectors.toList());
  }
}

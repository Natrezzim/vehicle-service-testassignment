package ru.testassignment.vehicleservice.repository;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.testassignment.vehicleservice.dto.Model;
import ru.testassignment.vehicleservice.jooq.Tables;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Models;

@Repository
public class ModelRepositoryImpl implements ModelRepository {

  DSLContext context;

  public ModelRepositoryImpl(DSLContext context) {
    this.context = context;
  }

  @Override
  public List<Models> findAllModels() {

    return context.selectFrom(Tables.MODELS).fetchInto(Models.class);
  }

  @Override
  public int updateModel(Model updateModel) {
    return context.update(Tables.MODELS).set(Tables.MODELS.NAME, updateModel.getName())
        .set(Tables.MODELS.CHARACTERISTICS, updateModel.getCharacteristics())
        .where(Tables.MODELS.ID.eq(updateModel.getId())).execute();
  }

  @Override
  public int createModel(Model newModel) {
    Record record = context
        .insertInto(
            Tables.MODELS,
            Tables.MODELS.NAME,
            Tables.MODELS.CHARACTERISTICS,
            Tables.MODELS.BRAND_ID)
        .values(
            newModel.getName(),
            newModel.getCharacteristics(),
            newModel.getBrandId())
        .returningResult(Tables.MODELS.ID)
        .fetchOne();
    return record.getValue(Tables.MODELS.ID);
  }

  @Override
  public int deleteModel(Model deleteModel) {
    return context.deleteFrom(Tables.MODELS).where(Tables.MODELS.ID.eq(deleteModel.getId()))
        .execute();
  }

  @Override
  public List<Models> findModelByName(String name) {
    return context.selectFrom(Tables.MODELS).where(Tables.MODELS.NAME.eq(name))
        .fetchInto(Models.class);
  }
}

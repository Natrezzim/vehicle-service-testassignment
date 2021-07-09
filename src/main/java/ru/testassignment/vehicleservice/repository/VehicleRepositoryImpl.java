package ru.testassignment.vehicleservice.repository;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.testassignment.vehicleservice.dto.Pdf;
import ru.testassignment.vehicleservice.dto.Vehicle;
import ru.testassignment.vehicleservice.jooq.Tables;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Vehicles;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

  DSLContext context;

  public VehicleRepositoryImpl(DSLContext context) {
    this.context = context;
  }

  @Override
  public List<Vehicles> findAllVehicles() {
    return context
        .selectFrom(Tables.VEHICLES)
        .fetchInto(Vehicles.class);
  }

  @Override
  public List<Vehicles> findVehiclesByFields(Integer ownerId, Integer brandId, Integer modelId) {
    return context.selectFrom(Tables.VEHICLES)
        .where(Tables.VEHICLES.OWNER_ID.eq(ownerId), Tables.VEHICLES.BRAND_ID.eq(brandId),
            Tables.VEHICLES.MODEL_ID.eq(modelId)).fetchInto(Vehicles.class);
  }

  @Override
  public int updateVehicle(Vehicle updateVehicle) {

    return context.update(Tables.VEHICLES).set(Tables.VEHICLES.OWNER_ID, updateVehicle.getOwnerId())
        .set(Tables.VEHICLES.BRAND_ID, updateVehicle.getBrandId())
        .set(Tables.VEHICLES.MODEL_ID, updateVehicle.getModelId())
        .where(Tables.VEHICLES.ID.eq(updateVehicle.getId())).execute();
  }

  @Override
  public Long createVehicle(Vehicle newVehicle) {

    Record record = context
        .insertInto(Tables.VEHICLES, Tables.VEHICLES.OWNER_ID, Tables.VEHICLES.BRAND_ID,
            Tables.VEHICLES.MODEL_ID)
        .values(newVehicle.getOwnerId(), newVehicle.getBrandId(), newVehicle.getModelId())
        .returningResult(Tables.VEHICLES.ID).fetchOne();

    return record.getValue(Tables.VEHICLES.ID);
  }

  @Override
  public int deleteVehicle(Vehicle deleteVehicle) {
    return context
        .deleteFrom(Tables.VEHICLES)
        .where(Tables.VEHICLES.ID.eq(deleteVehicle.getId()))
        .execute();
  }

  @Override
  public List<Pdf> pdfExport() {
    return context.selectFrom(
        Tables.VEHICLES.join(Tables.OWNERS).on(Tables.VEHICLES.OWNER_ID.eq(Tables.OWNERS.ID))
            .join(Tables.BRANDS).on(Tables.VEHICLES.BRAND_ID.eq(Tables.BRANDS.ID))
            .join(Tables.MODELS).on(Tables.VEHICLES.MODEL_ID.eq(Tables.MODELS.ID)))
        .fetchInto(Pdf.class);
  }
}

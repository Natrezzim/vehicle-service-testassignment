package ru.testassignment.vehicleservice.repository;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.testassignment.vehicleservice.dto.Brand;
import ru.testassignment.vehicleservice.jooq.Tables;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Brands;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

  DSLContext context;

  public BrandRepositoryImpl(DSLContext context) {
    this.context = context;
  }

  @Override
  public List<Brands> findAllBrands() {
    return context.selectFrom(Tables.BRANDS).fetchInto(Brands.class);
  }

  @Override
  public List<Brands> findBrandByName(String name) {
    return context.selectFrom(Tables.BRANDS).where(Tables.BRANDS.NAME.eq(name))
        .fetchInto(Brands.class);
  }

  @Override
  public int updateBrand(Brand updateBrand) {

    return context.update(Tables.BRANDS).set(Tables.BRANDS.NAME, updateBrand.getName())
        .where(Tables.BRANDS.ID.eq(updateBrand.getId())).execute();
  }

  @Override
  public int createBrand(Brand newBrand) {
    Record record =
        context
            .insertInto(Tables.BRANDS, Tables.BRANDS.NAME)
            .values(newBrand.getName())
            .returningResult(Tables.BRANDS.ID)
            .fetchOne();

    return record.getValue(Tables.BRANDS.ID);
  }

  @Override
  public int deleteBrand(Brand deleteBrand) {
    return context
        .deleteFrom(Tables.BRANDS)
        .where((Tables.BRANDS.ID).eq(deleteBrand.getId()))
        .execute();
  }
}

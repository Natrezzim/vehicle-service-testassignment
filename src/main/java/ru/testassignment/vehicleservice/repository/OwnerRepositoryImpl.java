package ru.testassignment.vehicleservice.repository;

import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;
import ru.testassignment.vehicleservice.dto.Owner;
import ru.testassignment.vehicleservice.jooq.Tables;
import ru.testassignment.vehicleservice.jooq.tables.pojos.Owners;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

  DSLContext context;

  public OwnerRepositoryImpl(DSLContext context) {
    this.context = context;
  }

  @Override
  public List<Owners> findAllOwners() {
    return context.selectFrom(Tables.OWNERS).fetchInto(Owners.class);
  }

  @Override
  public int updateOwner(Owner updateOwner) {
    return context.update(Tables.OWNERS).set(Tables.OWNERS.LAST_NAME, updateOwner.getLastName())
        .set(Tables.OWNERS.FIRST_NAME, updateOwner.getFirstName())
        .set(Tables.OWNERS.PATRONYMIC, updateOwner.getPatronymic())
        .where(Tables.OWNERS.ID.eq(updateOwner.getId())).execute();
  }

  @Override
  public int createOwner(Owner newOwner) {

    Record record = context.insertInto(
        Tables.OWNERS,
        Tables.OWNERS.LAST_NAME,
        Tables.OWNERS.FIRST_NAME,
        Tables.OWNERS.PATRONYMIC)
        .values(
            newOwner.getLastName(),
            newOwner.getFirstName(),
            newOwner.getPatronymic())
        .returningResult(Tables.OWNERS.ID)
        .fetchOne();

    return record.getValue(Tables.OWNERS.ID);
  }

  @Override
  public int deleteOwner(Owner deleteOwner) {

    return context.deleteFrom(Tables.OWNERS).where(Tables.OWNERS.ID.eq(deleteOwner.getId()))
        .execute();
  }

  @Override
  public List<Owners> findOwnerByLastName(String lastName) {
    return context.selectFrom(Tables.OWNERS).where(Tables.OWNERS.LAST_NAME.eq(lastName))
        .fetchInto(Owners.class);
  }

}

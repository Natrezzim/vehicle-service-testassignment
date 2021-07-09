/*
 * This file is generated by jOOQ.
 */
package ru.testassignment.vehicleservice.jooq.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import ru.testassignment.vehicleservice.jooq.tables.Owners;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OwnersRecord extends UpdatableRecordImpl<OwnersRecord> implements
    Record4<Integer, String, String, String> {

  private static final long serialVersionUID = 1L;

  /**
   * Create a detached OwnersRecord
   */
  public OwnersRecord() {
    super(Owners.OWNERS);
  }

  /**
   * Create a detached, initialised OwnersRecord
   */
  public OwnersRecord(Integer id, String firstName, String lastName, String patronymic) {
    super(Owners.OWNERS);

    setId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setPatronymic(patronymic);
  }

  /**
   * Getter for <code>public.owners.id</code>.
   */
  public Integer getId() {
    return (Integer) get(0);
  }

  /**
   * Setter for <code>public.owners.id</code>.
   */
  public OwnersRecord setId(Integer value) {
    set(0, value);
    return this;
  }

  /**
   * Getter for <code>public.owners.first_name</code>. Имя
   */
  public String getFirstName() {
    return (String) get(1);
  }

  /**
   * Setter for <code>public.owners.first_name</code>. Имя
   */
  public OwnersRecord setFirstName(String value) {
    set(1, value);
    return this;
  }

  /**
   * Getter for <code>public.owners.last_name</code>. Фамилия
   */
  public String getLastName() {
    return (String) get(2);
  }

  /**
   * Setter for <code>public.owners.last_name</code>. Фамилия
   */
  public OwnersRecord setLastName(String value) {
    set(2, value);
    return this;
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  /**
   * Getter for <code>public.owners.patronymic</code>. Отчество
   */
  public String getPatronymic() {
    return (String) get(3);
  }

  // -------------------------------------------------------------------------
  // Record4 type implementation
  // -------------------------------------------------------------------------

  /**
   * Setter for <code>public.owners.patronymic</code>. Отчество
   */
  public OwnersRecord setPatronymic(String value) {
    set(3, value);
    return this;
  }

  @Override
  public Record1<Integer> key() {
    return (Record1) super.key();
  }

  @Override
  public Row4<Integer, String, String, String> fieldsRow() {
    return (Row4) super.fieldsRow();
  }

  @Override
  public Row4<Integer, String, String, String> valuesRow() {
    return (Row4) super.valuesRow();
  }

  @Override
  public Field<Integer> field1() {
    return Owners.OWNERS.ID;
  }

  @Override
  public Field<String> field2() {
    return Owners.OWNERS.FIRST_NAME;
  }

  @Override
  public Field<String> field3() {
    return Owners.OWNERS.LAST_NAME;
  }

  @Override
  public Field<String> field4() {
    return Owners.OWNERS.PATRONYMIC;
  }

  @Override
  public Integer component1() {
    return getId();
  }

  @Override
  public String component2() {
    return getFirstName();
  }

  @Override
  public String component3() {
    return getLastName();
  }

  @Override
  public String component4() {
    return getPatronymic();
  }

  @Override
  public Integer value1() {
    return getId();
  }

  @Override
  public String value2() {
    return getFirstName();
  }

  @Override
  public String value3() {
    return getLastName();
  }

  @Override
  public String value4() {
    return getPatronymic();
  }

  @Override
  public OwnersRecord value1(Integer value) {
    setId(value);
    return this;
  }

  @Override
  public OwnersRecord value2(String value) {
    setFirstName(value);
    return this;
  }

  @Override
  public OwnersRecord value3(String value) {
    setLastName(value);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  @Override
  public OwnersRecord value4(String value) {
    setPatronymic(value);
    return this;
  }

  @Override
  public OwnersRecord values(Integer value1, String value2, String value3, String value4) {
    value1(value1);
    value2(value2);
    value3(value3);
    value4(value4);
    return this;
  }
}

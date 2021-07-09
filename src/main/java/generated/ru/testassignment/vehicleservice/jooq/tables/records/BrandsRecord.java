/*
 * This file is generated by jOOQ.
 */
package ru.testassignment.vehicleservice.jooq.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;
import ru.testassignment.vehicleservice.jooq.tables.Brands;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BrandsRecord extends UpdatableRecordImpl<BrandsRecord> implements
    Record2<Integer, String> {

  private static final long serialVersionUID = 1L;

  /**
   * Create a detached BrandsRecord
   */
  public BrandsRecord() {
    super(Brands.BRANDS);
  }

  /**
   * Create a detached, initialised BrandsRecord
   */
  public BrandsRecord(Integer id, String name) {
    super(Brands.BRANDS);

    setId(id);
    setName(name);
  }

  /**
   * Getter for <code>public.brands.id</code>.
   */
  public Integer getId() {
    return (Integer) get(0);
  }

  /**
   * Setter for <code>public.brands.id</code>.
   */
  public BrandsRecord setId(Integer value) {
    set(0, value);
    return this;
  }

  // -------------------------------------------------------------------------
  // Primary key information
  // -------------------------------------------------------------------------

  /**
   * Getter for <code>public.brands.name</code>. Название бренда
   */
  public String getName() {
    return (String) get(1);
  }

  // -------------------------------------------------------------------------
  // Record2 type implementation
  // -------------------------------------------------------------------------

  /**
   * Setter for <code>public.brands.name</code>. Название бренда
   */
  public BrandsRecord setName(String value) {
    set(1, value);
    return this;
  }

  @Override
  public Record1<Integer> key() {
    return (Record1) super.key();
  }

  @Override
  public Row2<Integer, String> fieldsRow() {
    return (Row2) super.fieldsRow();
  }

  @Override
  public Row2<Integer, String> valuesRow() {
    return (Row2) super.valuesRow();
  }

  @Override
  public Field<Integer> field1() {
    return Brands.BRANDS.ID;
  }

  @Override
  public Field<String> field2() {
    return Brands.BRANDS.NAME;
  }

  @Override
  public Integer component1() {
    return getId();
  }

  @Override
  public String component2() {
    return getName();
  }

  @Override
  public Integer value1() {
    return getId();
  }

  @Override
  public String value2() {
    return getName();
  }

  @Override
  public BrandsRecord value1(Integer value) {
    setId(value);
    return this;
  }

  // -------------------------------------------------------------------------
  // Constructors
  // -------------------------------------------------------------------------

  @Override
  public BrandsRecord value2(String value) {
    setName(value);
    return this;
  }

  @Override
  public BrandsRecord values(Integer value1, String value2) {
    value1(value1);
    value2(value2);
    return this;
  }
}
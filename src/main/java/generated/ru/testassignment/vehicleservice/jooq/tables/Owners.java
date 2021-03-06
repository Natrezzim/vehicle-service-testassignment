/*
 * This file is generated by jOOQ.
 */
package ru.testassignment.vehicleservice.jooq.tables;


import java.util.Arrays;
import java.util.List;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import ru.testassignment.vehicleservice.jooq.Keys;
import ru.testassignment.vehicleservice.jooq.Public;
import ru.testassignment.vehicleservice.jooq.tables.records.OwnersRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Owners extends TableImpl<OwnersRecord> {

  /**
   * The reference instance of <code>public.owners</code>
   */
  public static final Owners OWNERS = new Owners();
  private static final long serialVersionUID = 1L;
  /**
   * The column <code>public.owners.id</code>.
   */
  public final TableField<OwnersRecord, Integer> ID = createField(DSL.name("id"),
      SQLDataType.INTEGER.nullable(false).identity(true), this, "");
  /**
   * The column <code>public.owners.first_name</code>. Имя
   */
  public final TableField<OwnersRecord, String> FIRST_NAME = createField(DSL.name("first_name"),
      SQLDataType.CLOB.nullable(false), this, "Имя");
  /**
   * The column <code>public.owners.last_name</code>. Фамилия
   */
  public final TableField<OwnersRecord, String> LAST_NAME = createField(DSL.name("last_name"),
      SQLDataType.CLOB.nullable(false), this, "Фамилия");
  /**
   * The column <code>public.owners.patronymic</code>. Отчество
   */
  public final TableField<OwnersRecord, String> PATRONYMIC = createField(DSL.name("patronymic"),
      SQLDataType.CLOB.nullable(false), this, "Отчество");

  private Owners(Name alias, Table<OwnersRecord> aliased) {
    this(alias, aliased, null);
  }

  private Owners(Name alias, Table<OwnersRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /**
   * Create an aliased <code>public.owners</code> table reference
   */
  public Owners(String alias) {
    this(DSL.name(alias), OWNERS);
  }

  /**
   * Create an aliased <code>public.owners</code> table reference
   */
  public Owners(Name alias) {
    this(alias, OWNERS);
  }

  /**
   * Create a <code>public.owners</code> table reference
   */
  public Owners() {
    this(DSL.name("owners"), null);
  }

  public <O extends Record> Owners(Table<O> child, ForeignKey<O, OwnersRecord> key) {
    super(child, key, OWNERS);
  }

  /**
   * The class holding records for this type
   */
  @Override
  public Class<OwnersRecord> getRecordType() {
    return OwnersRecord.class;
  }

  @Override
  public Schema getSchema() {
    return Public.PUBLIC;
  }

  @Override
  public Identity<OwnersRecord, Integer> getIdentity() {
    return (Identity<OwnersRecord, Integer>) super.getIdentity();
  }

  @Override
  public UniqueKey<OwnersRecord> getPrimaryKey() {
    return Keys.OWNERS_PKEY;
  }

  @Override
  public List<UniqueKey<OwnersRecord>> getKeys() {
    return Arrays.<UniqueKey<OwnersRecord>>asList(Keys.OWNERS_PKEY);
  }

  @Override
  public Owners as(String alias) {
    return new Owners(DSL.name(alias), this);
  }

  @Override
  public Owners as(Name alias) {
    return new Owners(alias, this);
  }

  /**
   * Rename this table
   */
  @Override
  public Owners rename(String name) {
    return new Owners(DSL.name(name), null);
  }

  /**
   * Rename this table
   */
  @Override
  public Owners rename(Name name) {
    return new Owners(name, null);
  }

  // -------------------------------------------------------------------------
  // Row4 type methods
  // -------------------------------------------------------------------------

  @Override
  public Row4<Integer, String, String, String> fieldsRow() {
    return (Row4) super.fieldsRow();
  }
}

/*
 * This file is generated by jOOQ.
 */
package ru.testassignment.vehicleservice.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Owners implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String firstName;
  private String lastName;
  private String patronymic;

  public Owners() {
  }

  public Owners(Owners value) {
    this.id = value.id;
    this.firstName = value.firstName;
    this.lastName = value.lastName;
    this.patronymic = value.patronymic;
  }

  public Owners(
      Integer id,
      String firstName,
      String lastName,
      String patronymic
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.patronymic = patronymic;
  }

  /**
   * Getter for <code>public.owners.id</code>.
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Setter for <code>public.owners.id</code>.
   */
  public Owners setId(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Getter for <code>public.owners.first_name</code>. Имя
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Setter for <code>public.owners.first_name</code>. Имя
   */
  public Owners setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Getter for <code>public.owners.last_name</code>. Фамилия
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Setter for <code>public.owners.last_name</code>. Фамилия
   */
  public Owners setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Getter for <code>public.owners.patronymic</code>. Отчество
   */
  public String getPatronymic() {
    return this.patronymic;
  }

  /**
   * Setter for <code>public.owners.patronymic</code>. Отчество
   */
  public Owners setPatronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Owners other = (Owners) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (patronymic == null) {
      if (other.patronymic != null) {
        return false;
      }
    } else if (!patronymic.equals(other.patronymic)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
    result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
    result = prime * result + ((this.patronymic == null) ? 0 : this.patronymic.hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Owners (");

    sb.append(id);
    sb.append(", ").append(firstName);
    sb.append(", ").append(lastName);
    sb.append(", ").append(patronymic);

    sb.append(")");
    return sb.toString();
  }
}

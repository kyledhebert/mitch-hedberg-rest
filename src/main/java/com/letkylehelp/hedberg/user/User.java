package com.letkylehelp.hedberg.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letkylehelp.hedberg.core.BaseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

/**
 * @author kylehebert
 */
@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

  private String firstName;
  private String lastName;
  private String username;
  @JsonIgnore
  private String password;
  @JsonIgnore
  private String [] roles;

  protected User() {
    super();
  }

  public User(String firstName, String lastName, String username, String password,
              String[] roles) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    setPassword(password);
    this.roles = roles;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}

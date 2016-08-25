package com.letkylehelp.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Entity for auto-generating unique IDs for child Entities
 *
 * @author kylehebert
 */

@MappedSuperclass
public abstract class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private final Long id;
  @Version
  private Long version;

  protected BaseEntity() {
    id = null;
  }
}
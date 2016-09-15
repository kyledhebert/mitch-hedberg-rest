package com.letkylehelp.hedberg.joke;

import com.letkylehelp.hedberg.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity to represent a {@link Joke}
 *
 * @author kylehebert
 */

@Entity
public class Joke extends BaseEntity {
  private int rank;
  @Column(length = 1000)
  private String content;

  protected Joke() {
    super();
  }

  public Joke(int rank, String content) {
    this();
    this.rank = rank;
    this.content = content;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}

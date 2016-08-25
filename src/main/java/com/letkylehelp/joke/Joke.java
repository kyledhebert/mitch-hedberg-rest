package com.letkylehelp.joke;

import com.letkylehelp.core.BaseEntity;

import javax.persistence.Entity;

/**
 * Entity to represent a {@link Joke}
 *
 * @author kylehebert
 */

@Entity
public class Joke extends BaseEntity {
  private int rank;
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

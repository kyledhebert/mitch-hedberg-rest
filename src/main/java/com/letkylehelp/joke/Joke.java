package com.letkylehelp.joke;

import com.letkylehelp.core.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Joke extends BaseEntity {
    private int rank;
    private String jokeText;

    protected Joke() {
        super();
    }

    public Joke(int rank, String jokeText) {
        this();
        this.rank = rank;
        this.jokeText = jokeText;
    }
}

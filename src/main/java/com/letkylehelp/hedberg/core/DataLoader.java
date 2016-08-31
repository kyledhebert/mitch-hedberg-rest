package com.letkylehelp.hedberg.core;

import com.letkylehelp.hedberg.joke.Joke;
import com.letkylehelp.hedberg.joke.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Spring Component for loading jokes into the {@link JokeRepository}
 *
 * @author kylehebert
 */
@Component
public class DataLoader implements ApplicationRunner {

  private final JokeRepository jokes;

  @Autowired
  public DataLoader(JokeRepository jokes) {
    this.jokes = jokes;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<Joke> jokeList = Arrays.asList(
        new Joke(20, "A funny joke"),
        new Joke(19, "A really funny joke"),
        new Joke(18, "A really, really funny joke"),
        new Joke(17, "A funny joke"),
        new Joke(16, "A really funny joke"),
        new Joke(15, "A really, really funny joke"),
        new Joke(14, "A funny joke"),
        new Joke(12, "A really funny joke"),
        new Joke(13, "A really, really funny joke"),
        new Joke(11, "A funny joke"),
        new Joke(10, "A really funny joke"),
        new Joke(9, "A really, really funny joke"),
        new Joke(8, "A funny joke"),
        new Joke(7, "A really funny joke"),
        new Joke(6, "A really, really funny joke"),
        new Joke(5, "A really, really funny joke"),
        new Joke(4, "A really, really funny joke"),
        new Joke(3, "A really, really funny joke"),
        new Joke(3, "A really, really funny joke"),
        new Joke(2, "A really, really funny joke"),
        new Joke(1, "A really, really funny joke")
    );

    jokes.save(jokeList);

  }
}

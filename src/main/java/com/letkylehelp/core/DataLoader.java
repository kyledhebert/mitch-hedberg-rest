package com.letkylehelp.core;

import com.letkylehelp.joke.Joke;
import com.letkylehelp.joke.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    Joke joke = new Joke(1, "A funny joke");
    jokes.save(joke);

  }
}

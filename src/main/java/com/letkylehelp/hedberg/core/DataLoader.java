package com.letkylehelp.hedberg.core;

import com.letkylehelp.hedberg.joke.Joke;
import com.letkylehelp.hedberg.joke.JokeRepository;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    List<Joke> jokeList = readJokes();
    jokes.save(jokeList);
  }

  /**
   * Reads a file {@code mitch_jokes.csv} from the class path and parses it into {@link Joke} entities.
   *
   * @throws Exception
   */

  private static List<Joke> readJokes() throws Exception {
    ClassPathResource resource = new ClassPathResource("mitch_jokes.csv");
    Scanner scanner = new Scanner(resource.getInputStream());
    String line = scanner.nextLine();
    scanner.close();

    FlatFileItemReader<Joke> itemReader = new FlatFileItemReader<>();
    itemReader.setResource(resource);

    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    tokenizer.setNames(line.split(","));
    tokenizer.setStrict(false);

    DefaultLineMapper lineMapper = new DefaultLineMapper<Joke>();
    lineMapper.setFieldSetMapper(fieldSet ->
        new Joke(fieldSet.readInt("rank"), fieldSet.readString("content")));

    lineMapper.setLineTokenizer(tokenizer);
    itemReader.setLineMapper(lineMapper);
    itemReader.setRecordSeparatorPolicy(new DefaultRecordSeparatorPolicy());
    itemReader.setLinesToSkip(1);
    itemReader.open(new ExecutionContext());

    List<Joke> jokes = new ArrayList<>();
    Joke joke;

    do {

      joke = itemReader.read();

      if (joke != null) {
        jokes.add(joke);
      }

    } while (joke != null);

    return jokes;
  }
}

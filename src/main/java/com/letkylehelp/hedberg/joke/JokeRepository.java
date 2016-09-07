package com.letkylehelp.hedberg.joke;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for paginated access to {@link Joke}s and query methods
 *
 * @author kylehebert
 */
@Repository
public interface JokeRepository extends PagingAndSortingRepository<Joke, Long> {
  @RestResource(rel = "joke-contains", path = "containsWord")
  Page<Joke> findByContentContainingIgnoreCase(@Param("word") String word, Pageable pageable);
  @RestResource(rel = "get-top-five-jokes")
  List<Joke> findTop5ByOrderByRankAsc();
}

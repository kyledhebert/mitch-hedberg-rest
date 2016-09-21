package com.letkylehelp.hedberg.joke;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for paginated access to {@link Joke}s and query methods
 *
 * @author kylehebert
 */
@Repository
public interface JokeRepository extends PagingAndSortingRepository<Joke, Long> {
  Joke findByRank(@Param("rank") int rank);
  @RestResource(rel = "jokeContains", path = "containsWord")
  Page<Joke> findByContentContainingIgnoreCase(@Param("word") String word, Pageable pageable);
  @RestResource(rel = "getTopFiveJokes", path = "getTopFive")
  List<Joke> findTop5ByOrderByRankAsc();


//  Overriding these two delete methods only allows users with the
//  Admin role to delete Jokes
  @Override
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void delete(Long id);

  @Override
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  void delete(Joke entity);



}

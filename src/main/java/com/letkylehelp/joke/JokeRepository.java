package com.letkylehelp.joke;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository interface for paginated access to {@link Joke}s and query methods to find jokes by
 * id, rank, and search term
 *
 * @author kylehebert
 */

public interface JokeRepository extends PagingAndSortingRepository<Joke, Long> {
}

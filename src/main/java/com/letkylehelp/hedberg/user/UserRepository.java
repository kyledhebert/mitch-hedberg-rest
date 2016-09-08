package com.letkylehelp.hedberg.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author kylehebert
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}

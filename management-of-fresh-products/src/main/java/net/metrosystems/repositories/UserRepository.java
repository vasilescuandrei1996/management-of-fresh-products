package net.metrosystems.repositories;
import org.springframework.data.repository.CrudRepository;

import net.metrosystems.domain.User;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername(String username);
}

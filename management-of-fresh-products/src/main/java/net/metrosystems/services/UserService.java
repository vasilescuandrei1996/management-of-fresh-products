package net.metrosystems.services;

import net.metrosystems.domain.User;

public interface UserService {

    User getUserByUsername(String username);
}

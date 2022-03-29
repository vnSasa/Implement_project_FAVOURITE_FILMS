package my.favourite.films.service;

import my.favourite.films.domain.User;
import my.favourite.films.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{

	User getUserByEmail(String email);
	
}

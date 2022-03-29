package my.favourite.films.dao;

import my.favourite.films.domain.User;
import my.favourite.films.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {

	User getUserByEmail(String email);
	
}

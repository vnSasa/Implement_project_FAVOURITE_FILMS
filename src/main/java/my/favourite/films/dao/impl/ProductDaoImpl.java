package my.favourite.films.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import my.favourite.films.util.ConnectionUtils;
import my.favourite.films.dao.ProductDao;
import my.favourite.films.domain.Product;

public class ProductDaoImpl implements ProductDao {

	private static String READ_ALL = "select * from my_films.product";
	private static String CREATE = "insert into my_films.product('name', 'genre', 'alternativegenre', 'release') values (?,?,?,?)";
	private static String READ_BY_ID = "select * from my_films.product where id =?";
	private static String UPDATE_BY_ID = "update my_films.product set name=?, genre = ?, alternativegenre = ?, release = ? where id = ?";
	private static String DELETE_BY_ID = "delete from my_films.product where id=?";

	private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;

	public ProductDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Product create(Product product) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getGenre());
			preparedStatement.setString(3, product.getAlternativegenre());
			preparedStatement.setString(4, product.getRelease());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			product.setId(rs.getInt(1));
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer productId = result.getInt("id");
			String name = result.getString("name");
			String genre = result.getString("genre");
			String alternativegenre = result.getString("alternativegenre");
			String release = result.getString("release");
			product = new Product(productId, name, genre, alternativegenre, release);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public Product update(Product product) {

		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getGenre());
			preparedStatement.setString(3, product.getAlternativegenre());
			preparedStatement.setString(4, product.getRelease());
			preparedStatement.setInt(5, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Product> readAll() {
		List<Product> productRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer productId = result.getInt("id");
				String name = result.getString("name");
				String genre = result.getString("genre");
				String alternativegenre = result.getString("alternativegenre");
				String release = result.getString("release");

				productRecords.add(new Product(productId, name, genre, alternativegenre, release));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return productRecords;
	}

}

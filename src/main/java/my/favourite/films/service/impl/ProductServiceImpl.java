package my.favourite.films.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import my.favourite.films.dao.ProductDao;
import my.favourite.films.dao.impl.ProductDaoImpl;
import my.favourite.films.domain.Product;
import my.favourite.films.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private static Logger LOG = Logger.getLogger(ProductServiceImpl.class);
	private static ProductService productServiceImpl;
	private ProductDao productDao;

	public ProductServiceImpl() {
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}

		return productServiceImpl;
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}
}

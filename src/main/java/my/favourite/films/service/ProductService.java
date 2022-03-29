package my.favourite.films.service;

import java.util.Map;

import my.favourite.films.domain.Product;
import my.favourite.films.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product>{
	public Map<Integer, Product> readAllMap();
}

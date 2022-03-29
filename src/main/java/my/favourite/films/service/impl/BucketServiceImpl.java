package my.favourite.films.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import my.favourite.films.dao.BucketDao;
import my.favourite.films.dao.impl.BucketDaoImpl;
import my.favourite.films.domain.Bucket;
import my.favourite.films.service.BucketService;

public class BucketServiceImpl implements BucketService {

	private static Logger LOG = Logger.getLogger(BucketServiceImpl.class);
	private static BucketService bucketServiceImpl;
	private BucketDao bucketDao;
	
	public BucketServiceImpl() {
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}

		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);		
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}
}

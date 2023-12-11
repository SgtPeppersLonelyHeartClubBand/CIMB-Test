package id.aldin.cimb.test.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import id.aldin.cimb.test.dao.ProductDao;
import id.aldin.cimb.test.dao.ResponseProduct;
import id.aldin.cimb.test.dao.ResponseService;
import id.aldin.cimb.test.entity.Product;

public interface ProductRepo extends JpaRepository<Product, UUID> {

	@SuppressWarnings("unchecked")
	Product save(Product resp);
	
	Optional<Product> findById(UUID productId);
	
	
	
	
	
}


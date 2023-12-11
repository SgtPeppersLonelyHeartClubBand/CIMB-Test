package id.aldin.cimb.test.service;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import id.aldin.cimb.test.dao.ProductDao;
import id.aldin.cimb.test.dao.RequestProduct;
import id.aldin.cimb.test.dao.ResponseProduct;
import id.aldin.cimb.test.dao.ResponseService;
import id.aldin.cimb.test.entity.Product;
import id.aldin.cimb.test.repo.ProductRepo;
import id.aldin.cimb.test.util.Constants;
import id.aldin.cimb.test.util.DataNotFound;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public List<ResponseProduct> getAllProducts() throws Exception {
		ResponseService response = null;
		List<ResponseProduct> list = new ArrayList<>();
		try {

			List<Product> listDao = productRepo.findAll();
			if (listDao == null || listDao.size() == 0) {
				throw new DataNotFound(Constants.RESPONSE.DATA_NOT_FOUND.getDescription());
			}
			for (Product dao : listDao) {
				ResponseProduct resProduct = createDaftarProduct(dao);
				list.add(resProduct);
			}
			response = setResponse(Constants.RESPONSE.APPROVED, list);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	public Product createProduct(RequestProduct req) {
		ResponseService responseService = new ResponseService();
		String name = req.getName();
		Double price = req.getPrice();
		Integer quantity = req.getQuantity();

		Product resp = new Product();
		resp.setId(UUID.randomUUID());
		resp.setName(name);
		resp.setPrice(price);
		resp.setQuantity(quantity);
		resp.setCreatedAt(new Date());
		resp.setUpdateAt(new Date());

		return productRepo.save(resp);
		
	}

	private ResponseProduct createDaftarProduct(Product dao) {
		ResponseProduct productDto = new ResponseProduct();
		productDto.setId(dao.getId().toString());
		productDto.setName(dao.getName());
		productDto.setPrice(dao.getPrice().toString());
		productDto.setQuantity(dao.getQuantity().toString());
		productDto.setCreatedAt(dao.getCreatedAt().toGMTString());
		productDto.setUpdatedAt(dao.getUpdateAt().toGMTString());
		return productDto;
	}
	
	public Optional<Product> getProductById(UUID productId) {
        return productRepo.findById(productId);
    }

	public static ResponseService setResponse(Constants.RESPONSE response, Object obj) throws Exception {
		ResponseService res = new ResponseService();
		res.setResponseCode(response.getCode());
		res.setResponseDesc(response.getDescription());
		res.setData(obj);
		return res;
	}
}

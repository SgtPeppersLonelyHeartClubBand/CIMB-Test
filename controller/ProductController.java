package id.aldin.cimb.test.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.aldin.cimb.test.dao.ResponseService;
import id.aldin.cimb.test.entity.Product;
import id.aldin.cimb.test.service.ProductService;
import id.aldin.cimb.test.util.Constants;
import id.aldin.cimb.test.dao.*;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/all")
	@ResponseBody
	public ResponseService getAllProduct()
			throws Exception {
		ResponseService responseService = new ResponseService();
		try {

			List<ResponseProduct> list = productService.getAllProducts();
			if (list != null && list.size() > 0) {
				responseService.setResponseCode(Constants.RESPONSE.APPROVED.getCode());
				responseService.setResponseDesc(Constants.RESPONSE.APPROVED.getDescription());
				responseService.setData(list);
			} else {
				responseService.setResponseCode(Constants.RESPONSE.DATA_NOT_FOUND.getCode());
				responseService.setResponseDesc(Constants.RESPONSE.DATA_NOT_FOUND.getDescription());
			}
		} catch (Exception e) {
			throw e;
		}
		return responseService;
	}

	@PostMapping(value = "/add")
	@ResponseBody
	public ResponseService createProduct(@RequestBody @Validated RequestProduct req, BindingResult result)
			throws Exception {
		ResponseService responseService = new ResponseService();
		try {

			Product resp = productService.createProduct(req);
			if (resp == null) {
				responseService.setResponseCode(Constants.RESPONSE.DATA_NOT_FOUND.getCode());
				responseService.setResponseDesc(Constants.RESPONSE.DATA_NOT_FOUND.getDescription());
			}

			responseService.setResponseCode(Constants.RESPONSE.APPROVED.getCode());
			responseService.setResponseDesc(Constants.RESPONSE.APPROVED.getDescription());
			responseService.setData(resp);

		} catch (Exception e) {
			throw e;
		}
		return responseService;
	}

	@GetMapping("/{productId}")
	@ResponseBody
	public ResponseService getProductById(@PathVariable UUID productId) throws Exception {
		ResponseService responseService = new ResponseService();
		try {
			Optional<Product> product = productService.getProductById(productId);

			if (product == null) {
				responseService.setResponseCode(Constants.RESPONSE.DATA_NOT_FOUND.getCode());
				responseService.setResponseDesc(Constants.RESPONSE.DATA_NOT_FOUND.getDescription());
			}
			responseService.setResponseCode(Constants.RESPONSE.APPROVED.getCode());
			responseService.setResponseDesc(Constants.RESPONSE.APPROVED.getDescription());
			responseService.setData(product);
		} catch (Exception e) {
			throw e;
		}
		return responseService;

	}
}

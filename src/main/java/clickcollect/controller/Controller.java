package clickcollect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import clickcollect.DatabaseService;
import clickcollect.dao.DisplayProduct;
import clickcollect.dao.Product;
import clickcollect.service.ProductService;

@RestController
@RequestMapping("/api")
public class Controller {

	private ProductService productService;
	
	@Autowired
	public Controller(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(value="/products/all", method = RequestMethod.POST)
	public Iterable<DisplayProduct> getAllProducts() {
		System.out.println("getALlProducts");
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/products", method = RequestMethod.POST) 
	public ResponseEntity<?> getProduct(@RequestParam(name = "productID", required = true) String productID) {
		System.out.println("getProduct: " + productID);
		return new ResponseEntity<>(productService.getItem(productID), HttpStatus.OK);
	}
	
	@RequestMapping(value="/products/search", method = RequestMethod.POST) 
	public Iterable<DisplayProduct> searchProductByName(@RequestParam(name = "query", required = true) String query) {
		System.out.println("searchProductByName: " + query);
		return productService.searchByName(query);
	}
}

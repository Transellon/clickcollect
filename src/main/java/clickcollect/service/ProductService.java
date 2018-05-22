package clickcollect.service;

import java.util.List;

import clickcollect.dao.DisplayProduct;
import clickcollect.dao.Product;

public interface ProductService {
	public List<DisplayProduct> getAllProducts();
	public String getItem(String productID);
	public List<DisplayProduct> searchByName(String name);
}

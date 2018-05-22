package clickcollect.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import clickcollect.DatabaseService;
import clickcollect.dao.DisplayProduct;
import clickcollect.dao.Product;
import clickcollect.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String TABLE_PRODUCT = "Products"; 
	
	@Override
	public List<DisplayProduct> getAllProducts() {
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withLimit(100);
		
		DynamoDBMapper mapper = new DynamoDBMapper(DatabaseService.getInstance().getDynamoDBClient());
		
		List<DisplayProduct> scanResult = mapper.scan(DisplayProduct.class, scanExpression);
		
		return scanResult;
	}

	@Override
	public String getItem(String productID) {
		DynamoDB dynamoDB = new DynamoDB(DatabaseService.getInstance().getDynamoDBClient());
    	
    	Table table = dynamoDB.getTable(TABLE_PRODUCT);
    	
    	Item item = table.getItem("ProductID", productID);
		return item.toJSON();
	}

	@Override
	public List<DisplayProduct> searchByName(String query) {
		Map<String, AttributeValue> expressionAttributeValues = 
			    new HashMap<String, AttributeValue>();
			expressionAttributeValues.put(":name", new AttributeValue().withS(query)); 
			
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("productName = :name").withExpressionAttributeValues(expressionAttributeValues);
		
		DynamoDBMapper mapper = new DynamoDBMapper(DatabaseService.getInstance().getDynamoDBClient());
		
		List<DisplayProduct> scanResult = mapper.scan(DisplayProduct.class, scanExpression);
		
		return scanResult;
	}
}

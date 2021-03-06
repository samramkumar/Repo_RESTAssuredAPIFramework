package CommonFunctions;

import java.util.HashMap;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class purchasePage {
		public purchasePage() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void purchasemobile(RequestSpecification httpRequest, String mobilephones, HashMap<String, String> purchasedetails, HashMap<String, Double> purchaseprice){
		Response response = httpRequest.request(Method.GET,"productname/"+mobilephones);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(200, statusCode);
		String productid= response.jsonPath().get("productid").toString();
		System.out.println("Productid is "+productid);
		String productprice= response.jsonPath().get("productprice").toString().replace("[", "").replace("]", "");
		System.out.println("Product price is "+productprice);
		purchasedetails.put("ProductsPurchased", purchasedetails.get("ProductsPurchased")+productid);
		purchaseprice.put("TotalPrice", purchaseprice.get("TotalPrice")+Double.parseDouble(productprice));
	}
	
	public void purchasebook(RequestSpecification httpRequest, String books, HashMap<String, String> purchasedetails, HashMap<String, Double> purchaseprice){
		Response response = httpRequest.request(Method.GET,"productname/"+books);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(200, statusCode);
		String productid= response.jsonPath().get("productid").toString();
		System.out.println("Productid is "+productid);
		String productprice= response.jsonPath().get("productprice").toString().replace("[", "").replace("]", "");
		System.out.println("Product price is "+productprice);
		purchasedetails.put("ProductsPurchased", purchasedetails.get("ProductsPurchased")+productid);
		purchaseprice.put("TotalPrice", purchaseprice.get("TotalPrice")+Double.parseDouble(productprice));
	}
	
	public void purchaselaptops(RequestSpecification httpRequest, String laptops, HashMap<String, String> purchasedetails, HashMap<String, Double> purchaseprice){
		Response response = httpRequest.request(Method.GET,"productname/"+laptops);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(200, statusCode);
		String productid= response.jsonPath().get("productid").toString();
		System.out.println("Productid is "+productid);
		String productprice= response.jsonPath().get("productprice").toString().replace("[", "").replace("]", "");
		System.out.println("Product price is "+productprice);
		purchasedetails.put("ProductsPurchased", purchasedetails.get("ProductsPurchased")+productid);
		purchaseprice.put("TotalPrice", purchaseprice.get("TotalPrice")+Double.parseDouble(productprice));
	}
}

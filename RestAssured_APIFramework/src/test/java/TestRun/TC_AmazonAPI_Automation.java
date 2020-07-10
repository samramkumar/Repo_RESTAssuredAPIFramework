package TestRun;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import CommonFunctions.completeOrderPage;
import CommonFunctions.purchasePage;


public class TC_AmazonAPI_Automation {
	@SuppressWarnings("unchecked")
	@Test
	void completepurchase_placetheorder(){
		HashMap<String, String> purchasedetails = new HashMap<String, String>();
		HashMap<String, Double> purchaseprice = new HashMap<String, Double>();
		purchasedetails.put("ProductsPurchased", "");
		purchaseprice.put("TotalPrice", 0.0);
	    
		//GET API
		RestAssured.baseURI="http://localhost:9190/product/getProducts/";
		RequestSpecification httpRequest = RestAssured.given();
		
		purchasePage pp = new purchasePage();
		pp.purchasemobile(httpRequest,"IPhone6",purchasedetails,purchaseprice);
		pp.purchasebook(httpRequest,"Wings of Fire",purchasedetails,purchaseprice);
		pp.purchaselaptops(httpRequest,"Dell Inspiron",purchasedetails,purchaseprice);
		System.out.println(purchasedetails.get("ProductsPurchased"));
		System.out.println(purchaseprice.get("TotalPrice"));
		
		//POST API
		RestAssured.baseURI="http://localhost:9193/product/completetheorder";
		RequestSpecification httpRequest1 = RestAssured.given();
		
		completeOrderPage co = new completeOrderPage();
		co.submitorder(httpRequest1,purchasedetails.get("ProductsPurchased"),purchaseprice.get("TotalPrice"));
	}
}
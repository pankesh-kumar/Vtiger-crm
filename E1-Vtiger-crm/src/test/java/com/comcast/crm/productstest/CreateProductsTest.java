package com.comcast.crm.productstest;


import java.io.IOException;

import org.testng.annotations.Test;

import baseUtility.BaseClass;
import object_reprository.Products;


public class CreateProductsTest extends BaseClass {
	@Test
	
	public void CreateProducts() throws IOException {

	
// Create Products	
	
	Products p = new Products(driver);
	p.getClickOnProduct().click();                                   // click on product module
	
	p.getClickOnPlus().click();                                      // click on plus icon and add products
	
	p.getPassProductName().sendKeys("juci mango");                   // pass product name 
	
	p.getClickOnSaveBtn().click();                                   // click on save button 
	


	}

}

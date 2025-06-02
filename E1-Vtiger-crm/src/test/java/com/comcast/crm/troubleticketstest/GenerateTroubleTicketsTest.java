package com.comcast.crm.troubleticketstest;

import java.io.IOException;

import org.testng.annotations.Test;

import baseUtility.BaseClass;
import object_reprository.Tickets;

public class GenerateTroubleTicketsTest extends BaseClass {
	@Test
	
	public void TroubleTickets() throws IOException {


		
// click on trouble tickets and generate tickets
		
		Tickets tc = new Tickets(driver);
		
		tc.getClickOnTroubleTicket().click();
		tc.getClickOnPlus().click();                               // click on plus icon
		tc.getTitleName().sendKeys("green travel");                // send value in title field
		tc.getClickOnSaveBtn().click();                            // click on save button
		

	}

}

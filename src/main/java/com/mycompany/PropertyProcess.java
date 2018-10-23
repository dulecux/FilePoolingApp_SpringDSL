package com.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.example.customer.LookupCustomerRequestType;

public class PropertyProcess implements Processor {

	@Override
	public void process(Exchange ex) throws Exception {
		
		String[] parts = ex.getIn().getBody(String.class).split("_");
		
		ex.setProperty("firstName", parts[0]);
		ex.setProperty("lastName", parts[1]);
		ex.setProperty("address", parts[2]);
		ex.setProperty("city", parts[3]);
		ex.setProperty("state", parts[4]);
		ex.setProperty("telephone", parts[5]);
		ex.setProperty("email", parts[6]);
		int id = Integer.parseInt(parts[7]);
		ex.setProperty("customerId", id);
		
		LookupCustomerRequestType lcrt = new LookupCustomerRequestType();
		lcrt.setCustomerId(id);
		
		ex.getIn().setBody(lcrt);
		
		
		
	}

}

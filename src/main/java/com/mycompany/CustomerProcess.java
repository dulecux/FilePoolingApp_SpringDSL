package com.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomerProcess implements Processor {

	@Override
	public void process(Exchange ex) throws Exception {
		
		Customer cus = new Customer((String) ex.getProperty("firstName"),
                (String) ex.getProperty("lastName"),
                (String) ex.getProperty("address"),
                (String) ex.getProperty("city"),
                (String) ex.getProperty("state"),
                (String) ex.getProperty("telephone"),
                (String) ex.getProperty("email"),
                (Integer) ex.getProperty("customerId"));


               ex.getIn().setBody(cus);
	}

}

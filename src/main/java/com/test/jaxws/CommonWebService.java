package com.test.jaxws;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(name="CommonWebService",serviceName="CommonWebService")
public class CommonWebService {
	
	
	@WebMethod(action="getDate")
	public Date getDate() {
		
		return new Date();
	}

}

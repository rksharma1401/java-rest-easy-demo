package com.study.soap.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.rpc.soap.SOAPFaultException;

import com.study.vo.User;

@WebService
@HandlerChain(file="/handlers.xml")
public class SoapService implements Soap {

	@WebMethod
	public String sayHello() throws SOAPFaultException{
		return "Hello";
	}

	@WebMethod
	public User getUser(@WebParam(name="name") String name, @WebParam(name="company") String company, @WebParam(name="post") String post)  throws SOAPFaultException{
		return new User(name, company, post);
	}

	@Override
	public List<User> getUserList() throws SOAPFaultException{ 
		List<User> list=new ArrayList<User>();	
		for(int i=0;i<10;i++){
			list.add(new User("R "+i, "WP", "Dev "+i));
		}
		return list;
	}

	
}

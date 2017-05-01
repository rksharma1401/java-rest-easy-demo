package com.study.soap.service;

import java.util.List;

import javax.xml.rpc.soap.SOAPFaultException;

import com.study.vo.User;

public interface Soap {

	public String sayHello() throws SOAPFaultException;

	public  User getUser(String name, String company, String post) throws SOAPFaultException;
	
	public  List<User> getUserList() throws SOAPFaultException;

}
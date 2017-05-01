package com.study.soap.handlers;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.rpc.soap.SOAPFaultException;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SecurityHandler implements SOAPHandler<SOAPMessageContext> { 
	@Override
	public boolean handleMessage(SOAPMessageContext context) { 
		try {
			
			Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(!outboundProperty){
				System.out.println("------------------SecurityHandler Request Start -----------------------------");
				if(!"tokenValidate".equals(getHeaderToken(context))){
					//throw new SOAPFaultException(null, "Invalid token", "token issue", null);
					context.getMessage().getSOAPBody().removeContents();
					SOAPFault fault = context.getMessage().getSOAPBody().addFault( );
					QName faultName = new QName(SOAPConstants.URI_NS_SOAP_ENVELOPE, "Client");
					fault.setFaultCode(faultName);
					fault.setFaultActor("SOAP HEADER");
					fault.setFaultString("Invalid soap header"); 
					return false;
				}
				System.out.println("------------------SecurityHandler Request End   -----------------------------");
			}else{
				System.out.println("********************* SecurityHandler Response Start *****************************");
				
				System.out.println("********************* SecurityHandler Response End  *****************************");
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	private static String getHeaderToken(final SOAPMessageContext messageContext) throws Exception{
		Iterator it=messageContext.getMessage().getSOAPHeader().examineAllHeaderElements();
		while(it.hasNext()){
			SOAPHeaderElement  header=(SOAPHeaderElement) it.next();
			if(header.getElementQName().getLocalPart().equals("token"))
			System.out.println("Name : " + header.getElementQName().getLocalPart() +" , Value : " +header.getValue());
			return header.getValue();
		}
		return null;
		
	}
	
	private static SOAPMessageContext setFault(SOAPMessageContext messageContext) throws Exception{
		
		SOAPFaultException ex=new SOAPFaultException(null, "Invalid token", "token issue", null);
		
		return messageContext;
	}
	 

	@Override
	public boolean handleFault(SOAPMessageContext context) {
	 
		return false;
	}

	@Override
	public void close(MessageContext context) { 
		
	}

	@Override
	public Set<QName> getHeaders() { 
		return null;
	}

}

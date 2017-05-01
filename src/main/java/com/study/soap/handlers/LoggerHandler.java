package com.study.soap.handlers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class LoggerHandler implements SOAPHandler<SOAPMessageContext> { 
	@Override
	public boolean handleMessage(SOAPMessageContext context) { 
		try {
			
			Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if(outboundProperty){
				System.out.println("------------------ Response Start -----------------------------");
				System.out.println(printSoapMessage(context));
				System.out.println("------------------ Response End   -----------------------------");
			}else{
				System.out.println("------------------ Request Start -----------------------------");
				System.out.println(printSoapMessage(context));
				System.out.println("------------------ Request End   -----------------------------");
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	private static String printSoapMessage(final SOAPMessageContext messageContext){
		SOAPMessage msg = messageContext.getMessage();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			msg.writeTo(out);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return new String(out.toByteArray());
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("------------------------ SOAP FAULT ------------------" + printSoapMessage(context));
		return true;
	}

	@Override
	public void close(MessageContext context) { 
		
	}

	@Override
	public Set<QName> getHeaders() { 
		return null;
	}

}

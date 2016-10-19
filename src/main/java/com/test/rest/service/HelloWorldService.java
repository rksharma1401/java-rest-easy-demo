package com.test.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.GZIP;
import org.jboss.resteasy.annotations.cache.Cache;

import com.test.rest.vo.User;
 
/**<p>
 *	jax RS web service using resteasy and javax.rs
 * </p>
 *  @author ravikant.sharma
 *  
 */
@Path("/hello")
public class HelloWorldService {

	
	
	/**
	 * Method to return message as passed in query string
	 * @param msg :String Message
	 * @return User provide Message
	 * @author ravikant.sharma
	 */
	@GET
	@Path("getMsg/{param}")
	@Cache
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Resteasy say : " + msg;

		return Response.status(200).entity(output).build();

	}
	 
	/**
	 * Returns list on user 
	 * @return JSON list of user data
	 */
	@GET
	@Path("getData") 
	@Produces(MediaType.APPLICATION_JSON)
	@GZIP 
	public List<User> getData() {
		  CacheControl cc = new CacheControl();
		    cc.setMaxAge(86400);
      
			List<User> llstUser=new ArrayList<User>();
		for(int i=0;i<50;i++){
			User r=new User();
			r.setCompany("wp");
			r.setPost("Devloper");
			r.setName("userName");
			llstUser.add(r);
		}
		return llstUser ;//Response.status(200).entity(llstUser).build();

	}
	/**
	 * Return single user object
	 * @return JSON User class Object
	 */
	@GET
	@Path("getUser") 
	//@Produces(MediaType.APPLICATION_JSON)
	//@GZIP 
	public User getUser() { 
			User r=new User();
			r.setCompany("wp");
			r.setPost("Devloper");
			r.setName("userName"); 
		return r;//Response.status(200).entity(llstUser).build();

	}
	
	@GET
	@Path("getDataNoZip") 
	@Produces("application/json")
	public Response getDataNoZip() {
			List<User> llstUser=new ArrayList<User>();
		for(int i=0;i<50;i++){
			User r=new User();
			r.setCompany("wp");
			r.setPost("Devloper");
			r.setName("userName");
			llstUser.add(r);
		}
		return Response.status(200).entity(llstUser).build();

	}
	
	 
	 
	@GET
	@Path("getDefaultTimeZone") 
	@Produces(MediaType.TEXT_PLAIN)
	public String getCurrentDate() {
			 
		return TimeZone.getDefault().getDisplayName();  

	}
	
	@GET
	@Path("getCurrentDate/{param : .+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCurrentDate(@PathParam("param") String locale) { 
		return TimeZone.getTimeZone(locale).getDisplayName();  

	}
	
	@GET
	@Path("getMap")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getMap() { 
		Map<String, String> outputMap=new HashMap<String, String>();
		 
		outputMap.put("1", "One");
		outputMap.put("from module", "FROM mODULE mAP"); 
		return outputMap;  

	}

}

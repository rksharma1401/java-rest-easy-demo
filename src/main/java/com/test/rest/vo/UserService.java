/**
 * 
 */
package com.test.rest.vo;

/**
 * @author ravikant.sharma
 * Nov 11, 2016
 */
public class UserService {
	
	 User user=new User();
	
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @author : ravikant.sharma
	 * @since : Nov 11, 2016 3:20:38 PM
	 * @return void
	 * @param   
	 * @return 
	 */
	public String getName() {
		
		 return user.getName();

	}

}

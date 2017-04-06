/**
 * 
 */
package com.ws;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.test.rest.vo.User;
import com.test.rest.vo.UserService;

public class PortfolioTester {
   public static void main(String[] args){

      	

      //Create the mock object of stock service
	   User  user = mock(User.class);

      // mock the behavior of stock service to return the value of various stocks
      when(user.getName()).thenReturn("user1");

      UserService userService=new UserService();
      userService.setUser(user);
      System.out.println(userService.getName());
 
   }
}
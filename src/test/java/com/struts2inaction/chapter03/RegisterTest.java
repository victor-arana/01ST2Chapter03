package com.struts2inaction.chapter03;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

public class RegisterTest extends StrutsTestCase {

	public void testUserNameErrorMessage() throws Exception{
		
		request.setParameter("username", "");
		request.setParameter("password", "password");
		request.setParameter("portfolioName", "value");
		
		ActionProxy actionProxy = getActionProxy("/Register");		
		Register registerAction = (Register) actionProxy.getAction();		
		actionProxy.execute();
		
		assertTrue("Problem There were no errors present in fieldErrors but there should have been one error present", registerAction.getFieldErrors().size() == 1);
	}

}

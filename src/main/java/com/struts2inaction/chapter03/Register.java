package com.struts2inaction.chapter03;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2inaction.chapter03.utils.PortfolioService;
import com.struts2inaction.chapter03.utils.User;

/*
 * This is our first version of the Register action.  This version uses
 * the basic validation and message localization services provided by the 
 * ActionSupport help class.  By extending this class, we automatically
 * receive implementations of several interfaces that allow us to do
 * validation and localize our message texts with out polluting the
 * execute() method of our action.   
 */

public class Register extends ActionSupport {

	private static final long serialVersionUID = 3704526436133156955L;
	
	private PortfolioService portfolioService;

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setPassword(getPassword());
		user.setPortfolioName(getPortfolioName());
		user.setUsername(getUsername());
		
		getPortfolioService().createAccount(user);
		return SUCCESS;
	}
	
	/* JavaBeans Properties to Receive Request Parameters */
	private String username;
	private String password;
	private String portfolioName;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPortfolioName() {
		return portfolioName;
	}
	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}
	
	@Override
	public void validate() {
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
	
		/* Check that fields are not empty */
		if(getPassword().length() == 0){
			addFieldError("password", getText("password.required"));
		}
		if(getUsername().length() == 0){
			addFieldError("username", getText("username.required"));
		}
		if(getPortfolioName().length() == 0){
			addFieldError("portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if(ps.userExists(getUsername())){
			addFieldError("username", getText("user.exists"));
		}
	}
	
	public PortfolioService getPortfolioService(){
		return portfolioService;
	}
	public void setPortfolioService(PortfolioService portfolioService) {
		this.portfolioService = portfolioService;
	}

}

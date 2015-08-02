package com.struts2inaction.chapter03;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2inaction.chapter03.utils.PortfolioService;
import com.struts2inaction.chapter03.utils.User;

/*
 * This is our version of the Register action that uses object backed 
 * JavaBeans properties to receive the data transfer.  This classes uses
 * uses an application domain object, the user, as a JavaBeans property
 * in order to let the framework take over the tedious task of instantiating
 * the user object and assembling the individual datum onto it.  
 */

public class Register extends ActionSupport {

	private static final long serialVersionUID = 3704526436133156955L;

	/*
	 * Create and move the data onto our application domain object, user.
	 */
	@Override
	public String execute() throws Exception {		
		getPortfolioService().createAccount(user);
		return SUCCESS;
	}
	
	/* JavaBeans Properties to Receive Request Parameters */
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/* Validateable Implementation 
	 * 
	 * The validate method validates, invoked by the validation interceptor in
	 * the default stack, will validate the data already set on the action
	 * by the params interceptor, also in the default stack.  
	 * 
	 * If this method finds problems in validation it stores error messages via
	 * the methods exposed by the ValidationAware interface -- already implemented
	 * by the ActionSupport class that this action extends.  To complete the 
	 * the validation process, the workflow interceptor fires next in the default
	 * stack.  It checks for error messages on the action, and if it finds them 
	 * it diverts workflow back to the input page where the error messages are 
	 * displayed to the user.  In this case, the execute method of the action
	 * will not be called because the workflow was diverted, due to validation
	 * problems, before execution reached the action itself.
	 * 
	 */
	@Override
	public void validate() {
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
	
		/* Check that fields are not empty */
		if(getUser().getPassword().length() == 0){
			addFieldError("user.password", getText("password.required"));
		}
		if(getUser().getUsername().length() == 0){
			addFieldError("user.username", getText("username.required"));
		}
		if(getUser().getPortfolioName().length() == 0){
			addFieldError("user.portfolioName", getText("portfolioName.required"));
		}
		/* Make sure user doesn't already have an account */
		if(ps.userExists(getUser().getUsername())){
			addFieldError("user.username", getText("user.exists"));
		}
	}
	
	/*  
	 * Simple way to retrieve our business logic and data persistence
	 * object.  Late versions of the portfolio app will integrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService(){
		return new PortfolioService();
	}

}

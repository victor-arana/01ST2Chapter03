package com.struts2inaction.chapter03;

import java.io.File;
import java.io.IOException;

import com.struts2inaction.chapter03.utils.PortfolioService;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action uploads an image file using the default fileUpload 
 * interceptor.  The interceptor is in the default stack and the only
 * thing we have to do here in the action is implement JavaBean's 
 * properties to receive the File and meta-data from the interceptor.
 */

public class ImageUpload extends ActionSupport {

	public String execute() {

		/*
		 * Add the image to the portfolio.
		 */

		// add image to account
		try {
			getPortfolioService().addImage(getPic(), getPicFileName(),fileSystemPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}

	/* JavaBeans Properties to Receive Request Parameters */

	File pic;
	String picContentType;
	String picFileName;
	String fileSystemPath;

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setFileSystemPath(String fileSystemPath) {
		this.fileSystemPath = fileSystemPath;
	}

	/*
	 * Simple way to retrieve our business logic and data peristence object.
	 * Late versions of the portfolio app will intergrate with more
	 * sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

}

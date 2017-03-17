package com.hzgg.nec.employeemanage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	
	private String downloadFilename;
	private InputStream content;
	public String getDownloadFilename() {
		return downloadFilename;
	}
	
	public InputStream getContent() throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("/img/help-manual.pdf");
		File file = new File(path);
		this.downloadFilename = file.getName();
		content = new FileInputStream(file);
		return content;
	}
	
	public String execute() throws Exception{
		return "success";
	}
}

package com.bihari.champion.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="indexBean")
public class IndexBean {
	private static final Logger logger = LoggerFactory.getLogger(IndexBean.class);
	
	private String hello="helloka";
	
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHello() {
		logger.info("Hello is got by the JSF!");
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
}

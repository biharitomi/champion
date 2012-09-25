package com.bihari.champion.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.primefaces.event.TabChangeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="templateBean")
public class TemplateBean {
	private static final Logger logger = LoggerFactory.getLogger(TemplateBean.class);
	
	public void onChange(TabChangeEvent event){
		logger.info("MENUITEM CLICKED!!!");
	}
	
	public void menuItemClicked(){
		logger.info("MENUITEM CLICKED!!!");
		System.out.println("AADSF");
		
	}
}

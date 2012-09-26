package com.bihari.champion.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@ManagedBean(name="templateBean")
public class TemplateBean implements Serializable {
	private static final String KAPCSOLAT_MENU_ITEM_ID = "kapcsolatMenuItem";
	private static final String REFERENCIAK_MENU_ITEM_ID = "referenciakMenuItem";
	private static final String INDEX_MENU_ITEM_ID = "indexMenuItem";
	private static final long serialVersionUID = 780441307539269686L;
	private static final Logger logger = LoggerFactory.getLogger(TemplateBean.class);
	
	private int tabMenuId=0;
	private String returnUrl="";
	
	public void setTabMenuId(int tabMenuId) {
		this.tabMenuId = tabMenuId;
	}

	public int getTabMenuId() {
		return tabMenuId;
	}
	
	public TemplateBean(){
		this.tabMenuId=0;
	}

	public void menuItemClicked(ActionEvent event){
		logger.info("Menu item clicked with id: "+event.getComponent().getId());
		if(event.getComponent().getId().equals(INDEX_MENU_ITEM_ID)){
			this.tabMenuId=0;
			this.returnUrl="/index";
		}
		else if(event.getComponent().getId().equals(REFERENCIAK_MENU_ITEM_ID)){
			this.tabMenuId=1;
			this.returnUrl="/views/referenciak";
		}
		else if(event.getComponent().getId().equals(KAPCSOLAT_MENU_ITEM_ID)){
			this.tabMenuId=2;
			this.returnUrl="/views/kapcsolat";
		}
		else{
			this.returnUrl="/index";
		}
	}
	
	public String returnAction(){
		return returnUrl;
	}
	
}

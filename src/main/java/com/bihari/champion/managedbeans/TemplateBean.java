package com.bihari.champion.managedbeans;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@ManagedBean(name="templateBean")
public class TemplateBean implements Serializable {
	
	private static final String TEVEKENYSEGEK_MENU_ITEM = "tevekenysegekMenuItem";
	private static final String PARTNEREINK_MENU_ITEM = "partnereinkMenuItem";
	private static final String CEGUNKROL_MENU_ITEM = "cegunkrolMenuItem";
	private static final String DIJAK_MENU_ITEM = "dijakMenuItem";
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
		logger.info("MainMenu item clicked with component id: "+event.getComponent().getId());
		
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
		else if(event.getComponent().getId().equals(DIJAK_MENU_ITEM)){
			this.tabMenuId=3;
			this.returnUrl="/views/dijak";
		}
		else if(event.getComponent().getId().equals(CEGUNKROL_MENU_ITEM)){
			this.tabMenuId=4;
			this.returnUrl="/views/cegunkrol";
		}
		else if(event.getComponent().getId().equals(PARTNEREINK_MENU_ITEM)){
			this.tabMenuId=5;
			this.returnUrl="/views/partnereink";
		}
		else if(event.getComponent().getId().equals(TEVEKENYSEGEK_MENU_ITEM)){
			this.tabMenuId=6;
			this.returnUrl="/views/tevekenysegek";
		}
		else{
			this.returnUrl="/index";
		}
	}
	
	public String returnAction(){
		return returnUrl+"?faces-redirect=true";
	}
	
}

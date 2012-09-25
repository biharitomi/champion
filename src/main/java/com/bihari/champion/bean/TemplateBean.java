package com.bihari.champion.bean;


import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="templateBean")
public class TemplateBean {
	private static final Logger logger = LoggerFactory.getLogger(TemplateBean.class);
	
	private MenuModel menuModel;
	
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void onChange(TabChangeEvent event){
		logger.info("MENUITEM CLICKED!!!");
	}
	
	public void menuItemClicked(){
		logger.info("MENUITEM CLICKED!!!");
		System.out.println("AADSF");
		
	}
	
	public String menuItemClicked2(){
		logger.info("DYNAMIC MENUITEM CLICKED!!!");
		for(Object o:FacesContext.getCurrentInstance().getAttributes().keySet()){
			logger.info("ATTRIBUTE: "+o.toString());
		}
		return "/views/kapcsolat.xhtml";
	}
	
	
	@PostConstruct
	private void init(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        ExpressionFactory expressionFactory = application.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        
		menuModel=new DefaultMenuModel();
		
		MenuItem item;
		
		item=new MenuItem();
		item.setId("xxx1");
		item.setValueExpression("value", expressionFactory.createValueExpression(elContext, "Home", String.class));
        item.setActionExpression(expressionFactory.createMethodExpression(elContext, "#{templateBean.menuItemClicked2}", String.class, new Class[0]));
        item.setAjax(false);
        item.setAsync(false);
        item.setUpdate(":dataForm");
        menuModel.addMenuItem(item);
        
        item=new MenuItem();
		item.setId("xxx2");
		item.setValueExpression("value", expressionFactory.createValueExpression(elContext, "Referenciák", String.class));
        item.setActionExpression(expressionFactory.createMethodExpression(elContext, "#{templateBean.menuItemClicked2}", String.class, new Class[0]));
        
        item.setAjax(false);
        item.setAsync(false);
        item.setUpdate(":dataForm");
        menuModel.addMenuItem(item);
	}
}

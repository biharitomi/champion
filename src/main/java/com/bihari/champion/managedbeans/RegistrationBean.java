package com.bihari.champion.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="registrationBean")
@RequestScoped
public class RegistrationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger=LoggerFactory.getLogger(RegistrationBean.class);
	
	private String username="";
	private String fullName="";
	private String email="";
	private String password="";
	private String passwordRe="";

	public void register(){
		boolean isAllFieldsValid=validateFields();
		if(isAllFieldsValid){
			logger.info("Register username:"+username);
			initFields();
			RequestContext.getCurrentInstance().execute("registrationDialog.hide()");
		}
	}
	
	public void cancelRegistration(){
		initFields();
		RequestContext.getCurrentInstance().execute("registrationDialog.hide()");
	}
	
	private void initFields(){
		username="";
		fullName="";
		email="";
		password="";
		passwordRe="";
	}
	
	private boolean validateFields() {
		boolean result=true;
		if(username==""){
			addFacesErrorMessage("registrationMessages","Kérem adjon meg a felhasználó nevét!");
			result=false;
		}
		else if(fullName==""){
			addFacesErrorMessage("registrationMessages","Kérem adjon meg a teljes nevét!");
			result=false;
		}
		else if(email==""){
			addFacesErrorMessage("registrationMessages","Kérem adjon meg az email címét!");
			result=false;
		}
		else if(password==""){
			addFacesErrorMessage("registrationMessages","Kérem adjon meg egy jelszót!");
			result=false;
		}
		else if(!password.equals(passwordRe)){
			addFacesErrorMessage("registrationMessages","A két jelszó nem megegyező!");
			result=false;
		}
		return result;
	}

	private void addFacesErrorMessage(String clientId, String message) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba!", message));
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRe() {
		return passwordRe;
	}
	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
	}
}

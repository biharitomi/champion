package com.bihari.champion.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@SessionScoped
@ManagedBean(name = "authBean")
public class AuthenticationBean {
	private static Logger logger=LoggerFactory.getLogger(AuthenticationBean.class);
	
	private String userName="";
	private String password="";
	private boolean isLoggedIn=false;
	private String loggedInUserName="";
	
	@ManagedProperty(value="#{authenticationManager}")
	private AuthenticationManager am;

	public void login() {
		try {
			Authentication request=new UsernamePasswordAuthenticationToken(userName, password);
			Authentication result=am.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return;
		}
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			this.loggedInUserName = ((UserDetails)principal).getUsername();
		} else {
			this.loggedInUserName = principal.toString();
		}
		logger.info("Login successfully for "+loggedInUserName);
		
		this.isLoggedIn=true;
	}
	
	public void logout(){
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
		logger.info("LOGOUT was successfully for "+loggedInUserName);
		this.loggedInUserName="";
		this.isLoggedIn=false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationManager getAm() {
		return am;
	}

	public void setAm(AuthenticationManager am) {
		this.am = am;
	}

	public boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	
}

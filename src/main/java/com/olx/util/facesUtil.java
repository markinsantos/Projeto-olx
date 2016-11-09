package com.olx.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class facesUtil {
	public static void addMsgInfo(String msg){
		FacesMessage faces = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, faces);
 	}
public static void addMsgErro(String msg){
	FacesMessage faces = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
	FacesContext fc = FacesContext.getCurrentInstance();
	fc.addMessage(null, faces);
	}

}

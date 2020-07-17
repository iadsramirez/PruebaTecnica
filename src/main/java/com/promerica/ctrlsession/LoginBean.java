/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.ctrlsession;



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




@Named(value = "logoutBean")
@RequestScoped
public class LoginBean {
    
     private static Logger log = Logger.getLogger(LoginBean.class.getName());

    public String logout() {
        
        String destination = "/login?faces-redirect=true";

        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = 
                (HttpServletRequest) context.getExternalContext().getRequest();

        try {
            
            HttpSession session = request.getSession();
            session.invalidate();
            
            request.logout();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            destination = "/loginerror?faces-redirect=true";
        }

        return destination; 
    }
    
}

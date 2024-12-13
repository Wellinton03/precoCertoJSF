/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 *
 * @author welli
 */
@ApplicationScoped
public class HeaderProvider {
    
    
    public HttpHeaders getHeadersWithToken() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

        String token = (String) externalContext.getSessionMap().get("authToken");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token); 
        return headers;
    }
}

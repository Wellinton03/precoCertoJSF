/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.dtoResponse;

/**
 *
 * @author welli
 */
public class LoginDTO {
    
    private String token;
    
    public LoginDTO() {
        
    }

    public LoginDTO(String token){
        this.token = token;
    }
    
    public String getToken() {
        System.out.println("Token recebido " + token);
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.beans;

import com.wellinton.precocertojsf.apiRequest.UsuarioRequest;
import com.wellinton.precocertojsf.dtoRequest.AuthenticationDTO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author welli
 */

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioRequest usuarioRequest;
    
    private AuthenticationDTO authenticationDTO;
    
    String passwordConfirmation;
    
    @PostConstruct
    public void init() {
        
      if(authenticationDTO == null) {
          authenticationDTO = new AuthenticationDTO();
      }   
    }
    
    public String salvar() {
        System.out.println(authenticationDTO.toString());
        if(authenticationDTO != null && passwordConfirmation.equals(authenticationDTO.getPassword())) {
            usuarioRequest.CadastrarUsuario(authenticationDTO);
        }
            
            return "TelaInicial?faces-redirect=true";
    }
    
    public String login() {
        System.out.println(authenticationDTO.toString());
        if(authenticationDTO.getUsername() != null || authenticationDTO.getPassword() != null) {
              usuarioRequest.logarUsuario(authenticationDTO);
        }
        
        return "TelaInicial?faces-redirect=true";
    }

    public AuthenticationDTO getAuthenticationDTO() {
        return authenticationDTO;
    }

    public void setAuthenticationDTO(AuthenticationDTO authenticationDTO) {
        this.authenticationDTO = authenticationDTO;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
    
    
    
    
}

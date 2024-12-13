/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.apiRequest;

import com.wellinton.precocertojsf.dtoRequest.AuthenticationDTO;
import com.wellinton.precocertojsf.dtoResponse.LoginDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author welli
 */
@ApplicationScoped
public class UsuarioRequest {
    
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/precoCerto/api/auth";
    
    public UsuarioRequest() {
        this.restTemplate = new RestTemplate();
    }
    
    
    public void CadastrarUsuario(AuthenticationDTO data) {
        String url = baseUrl + "/cadastrar";
        
        restTemplate.postForObject(url, data, Void.class);
    }
    
    public void logarUsuario(AuthenticationDTO authenticationDTO) {
    String url = baseUrl + "/login";
    
    try {
        LoginDTO dto = restTemplate.postForObject(url, authenticationDTO, LoginDTO.class);
        String token = dto.getToken();
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.getSessionMap().put("authToken", token);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Erro ao autenticar usuário: " + e.getMessage());
    }
}
    
}

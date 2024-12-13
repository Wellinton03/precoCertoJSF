/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.apiRequest;

import com.wellinton.precocertojsf.auth.HeaderProvider;
import com.wellinton.precocertojsf.dtoRequest.IndicadorDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author welli
 */

@ApplicationScoped
public class IndicadoresRequest {
    
    
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/precoCerto/api/indicador";
    
    @Inject
    private HeaderProvider header;
    
    public IndicadoresRequest() {
        this.restTemplate = new RestTemplate();
    }
    
    public List<IndicadorDTO> listarIndicadores() {
        String url = baseUrl + "/listar";
        
        HttpEntity<String> entity = new HttpEntity<>(header.getHeadersWithToken());
        return List.of(restTemplate.exchange(url, HttpMethod.GET, entity, IndicadorDTO[].class).getBody());
    }
    
    public void salvar(IndicadorDTO data) {
        String url = baseUrl + "/cadastrar";
        
        HttpEntity<IndicadorDTO> entity = new HttpEntity<>(data, header.getHeadersWithToken());
        restTemplate.postForObject(url, entity, Void.class);
    }
    
    public void editar(IndicadorDTO data) {
        String url = baseUrl + "/editar";
        
        HttpEntity<IndicadorDTO> entity = new HttpEntity<>(data, header.getHeadersWithToken());
        restTemplate.put(url, entity);
    }
    
     public void excluir(Long id) {
        String url = baseUrl + "/excluir/" + id;
        
         HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
         HttpEntity<String> entity = new HttpEntity<>("", header.getHeadersWithToken());
        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
    }
    
}

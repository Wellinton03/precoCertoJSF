/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.apiRequest;

import com.wellinton.precocertojsf.dtoRequest.IndicadorRequestDTO;
import com.wellinton.precocertojsf.dtoResponse.IndicadorResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
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
    
    public IndicadoresRequest() {
        this.restTemplate = new RestTemplate();
    }
    
    public List<IndicadorResponseDTO> listarIndicadores() {
        String url = baseUrl + "/listar";
        
        return List.of(restTemplate.getForObject(url, IndicadorResponseDTO[].class));
    }
    
    public void salvar(IndicadorRequestDTO data) {
        String url = baseUrl + "/cadastrar";
        
        restTemplate.postForObject(url, data, Void.class);
    }
    
     public void excluir(Long id) {
        String url = baseUrl + "/excluir/" + id;
        
         HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
         HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        
         restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class
   );
    }
    
}

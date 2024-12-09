/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.apiRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wellinton.precocertojsf.dtoRequest.CotacaoRequestDTO;
import com.wellinton.precocertojsf.dtoRequest.IndicadorRequestDTO;
import com.wellinton.precocertojsf.dtoResponse.CotacaoResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author welli
 */

@ApplicationScoped
public class CotacoesRequest {
    
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/precoCerto/api/cotacao";
    
     public CotacoesRequest() {
        this.restTemplate = createRestTemplate();
    }

    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        restTemplate.getMessageConverters().add(0, converter);

        return restTemplate;
    }
     
     public List<CotacaoResponseDTO> listarCotacoes() {
        String url = baseUrl + "/listar";
        
        return List.of(restTemplate.getForObject(url, CotacaoResponseDTO[].class));
    }
     
      public void salvar(CotacaoRequestDTO data) {
        String url = baseUrl + "/cadastrar";
        
        restTemplate.postForObject(url, data, Void.class);
    }
    
    public void editar(CotacaoRequestDTO data) {
        String url = baseUrl + "/editar";
        
        restTemplate.put(url, data, Void.class);
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

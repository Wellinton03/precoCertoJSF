/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.apiRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wellinton.precocertojsf.auth.HeaderProvider;
import com.wellinton.precocertojsf.dtoRequest.CotacaoRequestDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
    
    @Inject
    private HeaderProvider header;
    
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
     
     public List<CotacaoRequestDTO> listarCotacoes() {
        String url = baseUrl + "/listar";
        
        HttpEntity<String> entity = new HttpEntity<>(header.getHeadersWithToken());
        return List.of(restTemplate.exchange(url, HttpMethod.GET, entity, CotacaoRequestDTO[].class).getBody());
    }
     
      public void salvar(CotacaoRequestDTO data) {
        String url = baseUrl + "/cadastrar";
        
         HttpEntity<CotacaoRequestDTO> entity = new HttpEntity<>(data, header.getHeadersWithToken());
        restTemplate.postForObject(url, entity, Void.class);
    }
    
    public void editar(CotacaoRequestDTO data) {
        String url = baseUrl + "/editar";
        
         HttpEntity<CotacaoRequestDTO> entity = new HttpEntity<>(data, header.getHeadersWithToken());
        restTemplate.put(url, entity);
    }
    
     public void excluir(Long id) {
    String url = baseUrl + "/excluir/" + id;

    HttpEntity<String> entity = new HttpEntity<>("", header.getHeadersWithToken());
        restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
}
}

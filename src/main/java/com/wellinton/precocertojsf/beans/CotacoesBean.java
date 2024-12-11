/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.beans;

import com.wellinton.precocertojsf.apiRequest.CotacoesRequest;
import com.wellinton.precocertojsf.dtoRequest.CotacaoRequestDTO;
import com.wellinton.precocertojsf.dtoResponse.CotacaoResponseDTO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author welli
 */

@Named
@ViewScoped
public class CotacoesBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<CotacaoResponseDTO> cotacoes;
    
    private CotacaoRequestDTO cotacaoRequestDTO;
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    @Inject
    private CotacoesRequest cotacoesRequest;
    
    @PostConstruct
    public void init() {
        carregarCotacoes();
        
        if(cotacaoRequestDTO == null) {
            cotacaoRequestDTO = new CotacaoRequestDTO();
        }
        
    }
    
    public static String formatLocalDateTime(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
    
    public String salvar() {
        System.out.println("método de salvar foi chamado " + cotacaoRequestDTO.toString());
    if (cotacaoRequestDTO != null && cotacaoRequestDTO.getIndicadorRequestDTO().getId() != null && cotacaoRequestDTO.getId() == null) {
            cotacoesRequest.salvar(cotacaoRequestDTO);
            
    } else if(cotacaoRequestDTO  != null && cotacaoRequestDTO.getIndicadorRequestDTO().getId() != null && cotacaoRequestDTO.getId() != null) {
         cotacoesRequest.editar(cotacaoRequestDTO);
    }
    return "ListaDeCotacoes?faces-redirect=true"; 
}
    
    public void carregarCotacoes(){
        this.cotacoes = cotacoesRequest.listarCotacoes();
    }
    
    public List<CotacaoResponseDTO> getCotacoes() {
        return cotacoes;
    }

    public CotacaoRequestDTO getCotacaoRequestDTO() {
        return cotacaoRequestDTO;
    }

    public void setCotacaoRequestDTO(CotacaoRequestDTO cotacaoRequestDTO) {
        this.cotacaoRequestDTO = cotacaoRequestDTO;
    }
    
    
}

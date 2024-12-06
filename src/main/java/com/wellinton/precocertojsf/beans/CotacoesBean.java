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
    
    private CotacaoRequestDTO cotacaoSelecionada;
    
    @Inject
    private CotacoesRequest cotacoesRequest;
    
    @PostConstruct
    public void Init() {
        carregarCotacoes();
        
        if(cotacaoSelecionada == null) {
            cotacaoSelecionada = new CotacaoRequestDTO();
        }
    }
    
    public String salvar() {
    if (cotacaoSelecionada != null && cotacaoSelecionada.getIndicadorRequestDTO().getId() != null && cotacaoSelecionada.getId() == null) {
            cotacoesRequest.salvar(cotacaoSelecionada);
            
    } else if(cotacaoSelecionada  != null && cotacaoSelecionada.getIndicadorRequestDTO().getId() != null && cotacaoSelecionada.getId() != null) {
         cotacoesRequest.editar(cotacaoSelecionada);
    }
    return "ListaDeCotacoes?faces-redirect=true"; 
}
    
    public void carregarCotacoes(){
        this.cotacoes = cotacoesRequest.listarCotacoes();
    }
    
    public List<CotacaoResponseDTO> getCotacoes() {
        return cotacoes;
    }

    public CotacaoRequestDTO getCotacaoSelecionada() {
        return cotacaoSelecionada;
    }

    public void setCotacaoRequestDTO(CotacaoRequestDTO cotacaoSelecionada) {
        this.cotacaoSelecionada = cotacaoSelecionada;
    }
    
    
}

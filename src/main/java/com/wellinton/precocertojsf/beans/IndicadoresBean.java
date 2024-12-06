/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.wellinton.precocertojsf.beans;

import com.wellinton.precocertojsf.apiRequest.IndicadoresRequest;
import com.wellinton.precocertojsf.dtoRequest.IndicadorRequestDTO;
import com.wellinton.precocertojsf.dtoResponse.IndicadorResponseDTO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.Flash;
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
public class IndicadoresBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IndicadoresRequest indicadoresRequest;
    
    private IndicadorRequestDTO indicadorSelecionado;
    private List<IndicadorResponseDTO> indicadores;
    private String description;
    private Long id;
    
    
    @PostConstruct
    public void Init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            indicadorSelecionado = (IndicadorRequestDTO) flash.get("indicadorSelecionado");
        if(indicadorSelecionado == null) {
            System.out.println("IndicadorRequest está nulo");
            indicadorSelecionado = new IndicadorRequestDTO();
        }
        carregarIndicadores(); 
    }
    
     public String editar(IndicadorRequestDTO indicadorDTO) {
         Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
    flash.put("indicadorSelecionado", indicadorDTO); 

    return "CadastroDeIndicadores?faces-redirect=true";
}
    
    public void prepararExclusão(IndicadorResponseDTO indicadorResponse){
        if(indicadorResponse != null) {
             if (indicadorSelecionado == null) {
            indicadorSelecionado = new IndicadorRequestDTO();
        }
            indicadorSelecionado.setId(indicadorResponse.getId());
            indicadorSelecionado.setDescription(indicadorResponse.getDescription());
        }
    }
    
    public void carregarIndicadores() {
        this.indicadores = indicadoresRequest.listarIndicadores();
    }
    
    public List<IndicadorResponseDTO> getIndicadores() {
        return indicadores;
    }
    
    public String salvar() {
        if(indicadorSelecionado.getDescription() != null) {
            
        try {
                indicadoresRequest.salvar(indicadorSelecionado);
        } catch (Exception e ) {
            e.printStackTrace();
            
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,
            "Erro ao salvar o Indicador, Por favor tente novamente"));
            
            return null;
        }
        
    } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES,
                    "Por favor, adicione um Indicador válido e tente novamente"));
        }
        return "ListaDeIndicadores?faces-redirect=true";
    }
    
    
    
    public void excluir() {
        if(indicadorSelecionado.getId() != null) {
        indicadoresRequest.excluir(indicadorSelecionado.getId());
        carregarIndicadores();
}
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndicadorRequestDTO getIndicadorSelecionado() {
        return indicadorSelecionado;
    }

    public void setIndicadorSelecionado(IndicadorRequestDTO indicadorSelecionado) {
        this.indicadorSelecionado = indicadorSelecionado;
    }
    
    
    
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
package com.wellinton.precocertojsf.beans;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author welli
 */

/*
@Named
@ViewScoped
public class IndicadoresBean {
    
    @Inject
    private IndicadoresRequest indicadoresRequest;
    
    private IndicadorResponseDTO indicadorSelecionado;
    private List<IndicadorResponseDTO> indicadores;
    private String description;
    private Long id;
    
    
    @PostConstruct
    public void Init() {
        carregarIndicadores(); 
    }
    
    public void carregarIndicadores() {
        this.indicadores = indicadoresRequest.listarIndicadores();
    }
    
    public List<IndicadorResponseDTO> getIndicadores() {
        System.out.println(indicadores);
        return indicadores;
    }
    
    public String salvar() {
        if(description != null) {
            
        try {
            IndicadorDTO indicadorDTO = new IndicadorDTO(description, id);
                indicadoresRequest.salvar(indicadorDTO);
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
            System.out.println(indicadorSelecionado.getId());
        indicadoresRequest.excluir(indicadorSelecionado.getId());
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

    public IndicadorResponseDTO getIndicadorSelecionado() {
        return indicadorSelecionado;
    }

    public void setIndicadorSelecionado(IndicadorResponseDTO indicadorSelecionado) {
        this.indicadorSelecionado = indicadorSelecionado;
    }
    
    
    
    
}
*/
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.wellinton.precocertojsf.beans;

import com.wellinton.precocertojsf.apiRequest.IndicadoresRequest;
import com.wellinton.precocertojsf.dtoRequest.IndicadorDTO;
import jakarta.annotation.PostConstruct;
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
    
    private IndicadorDTO indicadorSelecionado;
    private List<IndicadorDTO> indicadores;
    
    
    @PostConstruct
    public void Init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
            indicadorSelecionado = (IndicadorDTO) flash.get("indicadorSelecionado");
            
        if(indicadorSelecionado == null) {
            indicadorSelecionado = new IndicadorDTO();
        }
        carregarIndicadores(); 
       
    }
    
     public String editar(IndicadorDTO indicadorRequestDTO) {
         Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

            flash.put("indicadorSelecionado", indicadorRequestDTO); 
            flash.setKeepMessages(true);
            flash.setRedirect(true);

    return "CadastroDeIndicadores?faces-redirect=true";
}
    
    public void prepararExclusão(IndicadorDTO indicadorRequestDTO){
        if(indicadorRequestDTO != null) {
            this.indicadorSelecionado = indicadorRequestDTO;
        }
    }
    
    public void carregarIndicadores() {
        this.indicadores = indicadoresRequest.listarIndicadores();
    }
    
    public List<IndicadorDTO> getIndicadores() {
        return indicadores;
    }
    
    public String salvar() {
    if (indicadorSelecionado != null && indicadorSelecionado.getId() == null) {
            indicadoresRequest.salvar(indicadorSelecionado);
            
    } else if(indicadorSelecionado != null && indicadorSelecionado.getId() != null) {
         indicadoresRequest.editar(indicadorSelecionado);
    }
    return "ListaDeIndicadores?faces-redirect=true"; 
}
    
    
    
    public void excluir() {
        if(indicadorSelecionado.getId() != null) {
        indicadoresRequest.excluir(indicadorSelecionado.getId());
        carregarIndicadores();
}
        
    }

    public IndicadorDTO getIndicadorSelecionado() {
        return indicadorSelecionado;
    }

    public void setIndicadorSelecionado(IndicadorDTO indicadorSelecionado) {
        this.indicadorSelecionado = indicadorSelecionado;
    }
    
    public IndicadorDTO getIndicadorById(Long id) {
        System.out.println("id recebido no bean" + id);
    if (indicadores == null || id == null) {
        System.out.println(indicadores);
        return null;
    }
    return indicadores.stream()
                      .filter(indicador -> indicador.getId().equals(id))
                      .findFirst()
                      .orElse(null);
}
    
    
    
    
}
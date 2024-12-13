/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precocertojsf.beans;

import com.wellinton.precocertojsf.apiRequest.IndicadoresRequest;
import com.wellinton.precocertojsf.dtoRequest.IndicadorDTO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author welli
 */

@Named
@SessionScoped
public class IndicadoresSessaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IndicadoresRequest indicadorRequest;

    private List<IndicadorDTO> listaDeIndicadores;

    public void carregarIndicadores() {
        if (listaDeIndicadores == null) {
            listaDeIndicadores = indicadorRequest.listarIndicadores();
        }
    }

    public List<IndicadorDTO> getListaDeIndicadores() {
        if (listaDeIndicadores == null) {
            carregarIndicadores();
        }
        return listaDeIndicadores;
    }

    public IndicadorDTO getIndicadorById(Long id) {
        if (id == null) {
            System.out.println("ID fornecido é nulo.");
            return null;
        }
        carregarIndicadores(); 
        return listaDeIndicadores.stream()
                                  .filter(indicador -> indicador.getId().equals(id))
                                  .findFirst()
                                  .orElse(null);
    }
}


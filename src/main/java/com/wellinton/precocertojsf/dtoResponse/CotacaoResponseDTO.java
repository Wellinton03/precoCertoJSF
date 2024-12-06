/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoResponse;


/**
 *
 * @author welli
 */

public record CotacaoResponseDTO(Long id, IndicadorResponseDTO indicadorResponseDTO, String dataHora, Double valor) {

    public Long getId() {
        return id;
    }
    
    public IndicadorResponseDTO getIndicadorResponseDTO() {
        return indicadorResponseDTO;
    }
    
    public String getDataHora(){
        return dataHora;
    }
    
    public Double getValor(){
        return valor;
    }
}


    

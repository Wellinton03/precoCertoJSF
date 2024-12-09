/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoRequest;
import java.time.LocalDateTime;

/**
 *
 * @author welli
 */
public class CotacaoRequestDTO {

    Long id;
    IndicadorRequestDTO indicadorRequestDTO;
    LocalDateTime dataHora;
    Double valor;
    
    
    public CotacaoRequestDTO() {
        
    }
    
    public CotacaoRequestDTO(Long id, IndicadorRequestDTO indicadorRequestDTO, LocalDateTime dataHora, Double valor) {
        this.id = id;
        this.indicadorRequestDTO = indicadorRequestDTO;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndicadorRequestDTO getIndicadorRequestDTO() {
        return indicadorRequestDTO;
    }

    public void setIndicadorRequestDTO(IndicadorRequestDTO indicadorRequestDTO) {
        this.indicadorRequestDTO = indicadorRequestDTO;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        System.out.println(dataHora);
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CotacaoRequestDTO{" + "id=" + id + ", indicadorRequestDTO=" + indicadorRequestDTO + ", dataHora=" + dataHora + ", valor=" + valor + '}';
    }
    
    
    
    
}

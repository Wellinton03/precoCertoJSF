/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoRequest;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author welli
 */
public class CotacaoRequestDTO {

    private Long id;
    private IndicadorDTO indicadorDTO;
    private LocalDateTime dataHora;
    private Double valor;
    
    
    public CotacaoRequestDTO() {
        
    }
    
    public CotacaoRequestDTO(Long id, IndicadorDTO indicadorDTO, LocalDateTime dataHora, Double valor) {
        this.id = id;
        this.indicadorDTO = indicadorDTO;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndicadorDTO getIndicadorDTO() {
        return indicadorDTO;
    }

    public void setIndicadorDTO(IndicadorDTO indicadorDTO) {
        this.indicadorDTO = indicadorDTO;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
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
        return "CotacaoRequestDTO{" + "id=" + id + ", indicadorRequestDTO=" + indicadorDTO + ", dataHora=" + dataHora + ", valor=" + valor + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CotacaoRequestDTO other = (CotacaoRequestDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}

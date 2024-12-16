/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoRequest;

import java.util.Objects;

/**
 *
 * @author welli
 */
public class IndicadorDTO {

    private String description;
    private Long id;
    
    public IndicadorDTO(){
    
}
    
    public IndicadorDTO(String description, Long id) {
        this.id = id;
        this.description = description;
}
    
    public IndicadorDTO(String description) {
        this.description = description;
}
    
     public String getDescription() {
        return description;
    }

     
     public Long getId() {
         return id;
     }
     
     public void setDescription(String description) {
         if (description != null) {
            this.description = description.toUpperCase();
        }
     }
     
     public void setId(Long id) {
         this.id = id;
     }

    @Override
    public String toString() {
        return "IndicadorRequestDTO{" + "description=" + description + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final IndicadorDTO other = (IndicadorDTO) obj;
        return Objects.equals(this.id, other.id);
    }
     
     

}

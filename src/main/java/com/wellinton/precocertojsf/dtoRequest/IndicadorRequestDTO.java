/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoRequest;

/**
 *
 * @author welli
 */
public class IndicadorRequestDTO {

    private String description;
    private Long id;
    
    public IndicadorRequestDTO(){
    
}
    
    public IndicadorRequestDTO(String description, Long id) {
        this.id = id;
        this.description = description;
}
    
    public IndicadorRequestDTO(String description) {
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
     
     

}

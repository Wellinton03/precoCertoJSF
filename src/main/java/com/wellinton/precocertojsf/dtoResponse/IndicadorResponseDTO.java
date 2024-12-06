/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precocertojsf.dtoResponse;

/**
 *
 * @author welli
 */
public record IndicadorResponseDTO(String description, Long id) {
    
    
   public String getDescription() {
        return description;
    }

     
     public Long getId() {
         return id;
     }
    
    
}

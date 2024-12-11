package com.wellinton.precocertojsf.converter;

import com.wellinton.precocertojsf.beans.IndicadoresBean;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "indicadorDTOConverter")
public class IndicadorDTOConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("getAsObject chamado com valor: " + value);
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

         try {
            Long id = Long.parseLong(value);
            IndicadoresBean indicadoresBean = context.getApplication()
                                                     .evaluateExpressionGet(context, "#{indicadoresBean}", IndicadoresBean.class);
            return indicadoresBean.getIndicadorById(id);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para Long: " + value);
        } catch (Exception e) {
            System.err.println("Erro no conversor IndicadorDTOConverter: " + e.getMessage());
        }

        return null;
    }

   @Override
public String getAsString(FacesContext context, UIComponent component, Object value) {
    System.out.println("getAsString chamado com valor: " + value);

    if (value == null) {
        return "";
    }

    if (value instanceof Long) {
        return value.toString(); 
    }

    System.err.println("O valor não é uma instância de Long ou IndicadorRequestDTO: " + value);
    return "";
}
}

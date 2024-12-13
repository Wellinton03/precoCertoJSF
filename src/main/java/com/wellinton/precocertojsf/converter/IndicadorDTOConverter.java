package com.wellinton.precocertojsf.converter;

import com.wellinton.precocertojsf.beans.IndicadoresBean;
import com.wellinton.precocertojsf.dtoRequest.IndicadorDTO;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "indicadorDTOConverter", managed = true)
public class IndicadorDTOConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("getAsObject chamado com valor: " + value);

        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            Long id = Long.parseLong(value);

            IndicadoresBean bean = context.getApplication()
                                       .evaluateExpressionGet(context, "#{indicadoresBean}", IndicadoresBean.class);

            IndicadorDTO indicador = bean.getIndicadorById(id);
            
            return indicador;
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para Long: " + value);
        } catch (Exception e) {
            System.err.println("Erro no conversor IndicadorDTOConverter: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println(value);
        if (value == null) {
            return "";
        }

        if (value instanceof IndicadorDTO) {
            IndicadorDTO indicador = (IndicadorDTO) value;
             System.out.println("getAsString: Indicador ID retornado: " + indicador.getId());
            return indicador.getId() != null ? indicador.getId().toString() : "";
        }

        return "";
    }
}
package com.wellinton.precocertojsf.converter;

import com.wellinton.precocertojsf.beans.IndicadoresBean;
import com.wellinton.precocertojsf.dtoRequest.IndicadorRequestDTO;
import com.wellinton.precocertojsf.dtoResponse.IndicadorResponseDTO;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("indicadorDTOConverter")
public class IndicadorDTOConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            IndicadoresBean indicadoresBean = context.getApplication()
                                                     .evaluateExpressionGet(context, "#{indicadoresBean}", IndicadoresBean.class);

            Long id = Long.parseLong(value);
            IndicadorResponseDTO indicadorResponseDTO = indicadoresBean.getIndicadorById(id);

            if (indicadorResponseDTO != null) {
                IndicadorRequestDTO indicadorRequestDTO = new IndicadorRequestDTO();
                indicadorRequestDTO.setId(indicadorResponseDTO.getId());
                indicadorRequestDTO.setDescription(indicadorResponseDTO.getDescription());
                System.out.println(indicadorRequestDTO);
                return indicadorRequestDTO;
            }
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter valor para Long: " + value);
        } catch (Exception e) {
            System.err.println("Erro no conversor IndicadorDTOConverter: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || !(value instanceof IndicadorRequestDTO)) {
            return "";
        }
        IndicadorRequestDTO indicadorRequestDTO = (IndicadorRequestDTO) value;
        if (indicadorRequestDTO.getId() != null) {
            return indicadorRequestDTO.getId().toString();
        }
        return "";
    }
}

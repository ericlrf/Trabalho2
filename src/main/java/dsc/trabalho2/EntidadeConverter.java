package dsc.trabalho2;

import dsc.trabalho2.entidades.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "entidadeConverter")
public class EntidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            return (Usuario) component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object entity) {
        if (entity != null && entity instanceof Usuario) {
            component.getAttributes().put(((Usuario) entity).getId().toString(), entity);
            return ((Usuario) entity).getId().toString();
        }
        return null;
    }
}

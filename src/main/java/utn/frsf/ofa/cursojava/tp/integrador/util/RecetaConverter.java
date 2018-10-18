/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.tp.integrador.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import utn.frsf.ofa.cursojava.tp.integrador.modelo.Receta;

/**
 *
 * @author casanchez
 */
@FacesConverter("recetaConverter")
public class RecetaConverter  implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        String[] datos = string.split(";");
        Receta i = new Receta();
        i.setId(Integer.valueOf(datos[0]));
        i.setTitulo(datos[1]);
        return i;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Receta a = (Receta) t;
        return a.getId()+";"+a.getTitulo();      
    }
   
}

package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import beans.AvailableBean;
import entities.Vehicul;



@FacesConverter("ac")
public class CarConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String string) {
		if (string == null) {
			return null;
		}
		AvailableBean aBean = context.getApplication().evaluateExpressionGet(
				context, "#{availableBean}", AvailableBean.class);
		Vehicul car = aBean.doFindCarByName(string);

		return car;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object object) {
		String string = null;
		if (object instanceof Vehicul) {
			string = ((Vehicul) object).getType();
		}
		return string;
	}

}

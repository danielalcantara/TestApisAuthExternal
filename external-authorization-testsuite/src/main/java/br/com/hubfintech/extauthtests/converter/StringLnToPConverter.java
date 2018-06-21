package br.com.hubfintech.extauthtests.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.hubfintech.extauthtests.util.IFacesUtil;
import br.com.hubfintech.extauthtests.util.IMessagesUtil;

@FacesConverter("strlntopcon")
public class StringLnToPConverter implements Converter {

	@Inject
	IFacesUtil facesUtil;

	@Inject
	IMessagesUtil messages;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 == null || arg2.isEmpty()) {
			return "";
		}

		return arg2;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

		String pValue = "<p>";
		String lnValue = "\n";
		String inputVal = "";
		
		if (value == null) {
			return "";
		}
		
		// value must be of a type that can be cast to a String.
		try {
			
			if (value instanceof String)
				inputVal = (String) value;
			else
				return value.toString();
			
			if (inputVal.isEmpty())
				return "";
			
			if (inputVal.contains(lnValue))
				inputVal = inputVal.replace(lnValue, pValue).trim();
			
		} catch (ClassCastException ce) {
			facesUtil.setMessageErro(messages.getMessage("msg.error.converter.strna"));
			throw new ConverterException(ce);
		}
		
		return inputVal;
	}

}

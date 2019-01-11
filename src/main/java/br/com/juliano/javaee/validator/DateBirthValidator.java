package br.com.juliano.javaee.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DateBirthValidator implements Validator<Date>{

	@Override
	public void validate(FacesContext context, UIComponent component, Date date) throws ValidatorException {
		boolean result = date == null ? true : date.toString().trim().isEmpty();
		FacesMessage message;
		if(result) {
			message = new FacesMessage("Data é inválida");
			throw new ValidatorException(message);
		}
		
		Date now = new Date();
		if(date.after(now)) {
			message = new FacesMessage("A data digitada é maior que a data atual");
			throw new ValidatorException(message);
		}
	}

}

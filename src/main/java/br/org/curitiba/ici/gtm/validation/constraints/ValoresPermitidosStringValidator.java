package br.org.curitiba.ici.gtm.validation.constraints;

import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValoresPermitidosStringValidator implements ConstraintValidator<ValoresPermitidosString, String> {

	
	private String[] valoresPermitidos;

	@Override
	public void initialize(ValoresPermitidosString params) {
		valoresPermitidos = params.valoresPermitidos();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null)
			return true;
		return Stream.of(valoresPermitidos).filter(valor -> valor.equals(value)).count() > 0;
	}

}

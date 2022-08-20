package br.org.curitiba.ici.gtm.validation.constraints;

import java.lang.annotation.Annotation;

import javax.validation.Payload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ValoresPermitidosStringValidatorTest {

	@Test
	void naoDevePermitirValoresDiferenteDeAouB() {
		ValoresPermitidosStringValidator validator = new ValoresPermitidosStringValidator();
		validator.initialize(new ValoresPermitidosString() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] valoresPermitidos() {
				return new String[] {"A", "B"};
			}
			
			@Override
			public Class<? extends Payload>[] payload() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String message() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Class<?>[] groups() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		Assertions.assertFalse(validator.isValid("D", null));
	}
	
	@Test
	void devePermitirValoresIguaisAouB() {
		ValoresPermitidosStringValidator validator = new ValoresPermitidosStringValidator();
		validator.initialize(new ValoresPermitidosString() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] valoresPermitidos() {
				return new String[] {"A", "B"};
			}
			
			@Override
			public Class<? extends Payload>[] payload() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String message() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Class<?>[] groups() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		Assertions.assertTrue(validator.isValid("A", null));
		Assertions.assertTrue(validator.isValid("B", null));
	}
	
	@Test
	void devePermitirValorIgualANulo() {
		ValoresPermitidosStringValidator validator = new ValoresPermitidosStringValidator();
		Assertions.assertTrue(validator.isValid(null, null));
		
	}

}

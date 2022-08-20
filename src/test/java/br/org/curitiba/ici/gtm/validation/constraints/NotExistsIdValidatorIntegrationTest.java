package br.org.curitiba.ici.gtm.validation.constraints;

import java.lang.annotation.Annotation;

import javax.validation.Payload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class NotExistsIdValidatorIntegrationTest {

	@Test
	void existePessoaNoBancoDeDados() {
		NotExistsIdValidator notExisteIdValidator = new NotExistsIdValidator();
		notExisteIdValidator.initialize(new NotExistsId() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
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
			
			@Override
			public String fieldName() {
				return "codPessoa";
			}
			
			@Override
			public Class<?> domainClass() {
				return PessoaEntity.class;
			}
		});
		Assertions.assertFalse(notExisteIdValidator.isValid(1, null));

	}
	
	@Test
	void naoExistePessoaNoBancoDeDados() {
		NotExistsIdValidator notExisteIdValidator = new NotExistsIdValidator();
		notExisteIdValidator.initialize(new NotExistsId() {
			
			@Override
			public Class<? extends Annotation> annotationType() {
				// TODO Auto-generated method stub
				return null;
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
			
			@Override
			public String fieldName() {
				return "codPessoa";
			}
			
			@Override
			public Class<?> domainClass() {
				return PessoaEntity.class;
			}
		});
		Assertions.assertTrue(notExisteIdValidator.isValid(-100, null));

	}
	
	@Test
	void devePermitirValorIgualANulo() {
		NotExistsIdValidator validator = new NotExistsIdValidator();
		Assertions.assertTrue(validator.isValid(null, null));
		
	}

}

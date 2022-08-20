package br.org.curitiba.ici.gtm.validation.constraints;

import java.lang.annotation.Annotation;

import javax.validation.Payload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.org.curitiba.ici.gtm.entity.PessoaEntity;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ExistsIdValidatorIntegrationTest {

	@Test
	void existePessoaNoBancoDeDados() {
		ExistsIdValidator existeIdValidator = new ExistsIdValidator();
		existeIdValidator.initialize(new ExistsId() {
			
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
		Assertions.assertTrue(existeIdValidator.isValid(7, null));

	}
	
	@Test
	void naoExistePessoaNoBancoDeDados() {
		ExistsIdValidator existeIdValidator = new ExistsIdValidator();
		existeIdValidator.initialize(new ExistsId() {
			
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
		Assertions.assertFalse(existeIdValidator.isValid(-100, null));
	}
	
	@Test
	void devePermitirValorIgualANulo() {
		ExistsIdValidator validator = new ExistsIdValidator();
		Assertions.assertTrue(validator.isValid(null, null));
		
	}

}

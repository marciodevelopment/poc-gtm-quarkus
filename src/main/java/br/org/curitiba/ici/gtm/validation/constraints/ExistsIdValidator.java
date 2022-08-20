package br.org.curitiba.ici.gtm.validation.constraints;



import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
	private String domainAttribute;
	private Class<?> klass;
	private JpaOperations jpaOperations = new JpaOperations();
	
	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		Query query = jpaOperations.getEntityManager().createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
		query.setMaxResults(1);
		query.setParameter("value", value);
		return !query.getResultList().isEmpty();
	}
	
}

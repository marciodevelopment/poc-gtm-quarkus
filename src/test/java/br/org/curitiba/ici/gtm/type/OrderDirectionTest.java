package br.org.curitiba.ici.gtm.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.panache.common.Sort.Direction;

class OrderDirectionTest {

	@Test
	void deveRetornarAscending() {
		Assertions.assertEquals(OrderDirection.ASCENDING, OrderDirection.fromString("AsC"));
	}
	
	@Test
	void deveRetornarDescending() {
		Assertions.assertEquals(OrderDirection.DESCENDING, OrderDirection.fromString("deSC"));
	}
	
	@Test
	void deveRetornarDescendinParaValorNulo() {
		Assertions.assertEquals(OrderDirection.DESCENDING, OrderDirection.fromString(null));
	}
	
	@Test
	void deveRetornarDescendingParaValorInvalido() {
		Assertions.assertEquals(OrderDirection.DESCENDING, OrderDirection.fromString("asdfasdf"));
	}
	
	@Test
	void toPanacheDiretionDeveRetornarDescending() {
		Assertions.assertEquals(Direction.Descending, OrderDirection.DESCENDING.toPanacheDirection());
	}
	
	@Test
	void toPanacheDiretionDeveRetornarAscending() {
		Assertions.assertEquals(Direction.Ascending, OrderDirection.ASCENDING.toPanacheDirection());
	}
	

}

package br.org.curitiba.ici.gtm.web.resource.request;

import javax.ws.rs.QueryParam;

import br.org.curitiba.ici.gtm.type.OrderDirection;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaginationRequest {
	@QueryParam("page")
	private int page = 0;
	@QueryParam("page-size")
	private int pageSize = 10;
	@QueryParam("direction")
	private String direction = "desc";
	
	public OrderDirection getDirection() {
		return OrderDirection.fromString(direction);
	}
}

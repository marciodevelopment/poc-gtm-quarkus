package br.org.curitiba.ici.gtm.web.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.org.curitiba.ici.gtm.service.BancoService;
import br.org.curitiba.ici.gtm.web.resource.response.BancoResponse;
import lombok.RequiredArgsConstructor;

@Path("/bancos")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class BancoResource {
	private final BancoService bancoService;

	@GET
	public List<BancoResponse> list() {
		return bancoService.listAll()
				.stream()
				.map(BancoResponse::new)
				.collect(Collectors.toList());
	}
}
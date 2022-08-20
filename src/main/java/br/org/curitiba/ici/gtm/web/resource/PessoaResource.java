package br.org.curitiba.ici.gtm.web.resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.org.curitiba.ici.gtm.service.PessoaService;
import br.org.curitiba.ici.gtm.web.resource.request.PaginationRequest;
import br.org.curitiba.ici.gtm.web.resource.response.PessoaResponse;
import lombok.RequiredArgsConstructor;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class PessoaResource {
	private final PessoaService pessoaService;
	
	@GET
	public List<PessoaResponse> pesquisar(@BeanParam PaginationRequest paginationRequest, @QueryParam("nome") Optional<String> nome) {
		return pessoaService.pesquisar(nome, 
					paginationRequest.getDirection(), 
					paginationRequest.getPage(), 
					paginationRequest.getPageSize())
				.stream().map(PessoaResponse::new)
				.collect(Collectors.toList());
	}
}
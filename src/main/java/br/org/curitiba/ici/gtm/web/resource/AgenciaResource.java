package br.org.curitiba.ici.gtm.web.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.org.curitiba.ici.gtm.entity.AgenciaEntity;
import br.org.curitiba.ici.gtm.service.AgenciaService;
import br.org.curitiba.ici.gtm.service.BancoService;
import br.org.curitiba.ici.gtm.service.PessoaService;
import br.org.curitiba.ici.gtm.web.resource.request.AtualizacaoAgenciaRequest;
import br.org.curitiba.ici.gtm.web.resource.request.NovaAgenciaRequest;
import br.org.curitiba.ici.gtm.web.resource.request.PaginationRequest;
import br.org.curitiba.ici.gtm.web.resource.response.AgenciaResponse;
import lombok.RequiredArgsConstructor;

@Path("/agencias")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class AgenciaResource {
	private final AgenciaService agenciaService;
	private final BancoService bancoService;
	private final PessoaService pessoaService;
	
	@POST
	public Response salvar(@Valid NovaAgenciaRequest request) {
		AgenciaEntity agencia = request.toModel(pessoaService, bancoService);
		agenciaService.persist(agencia);
		return Response.created(URI.create("/agencias/cod-pessoa/" + agencia.getPessoa().getCodPessoa())).build();
	}
	

	@PUT
	@Path(value = "/cod-pessoa/{cod-pessoa}")
	public Response atualizar(@Valid AtualizacaoAgenciaRequest request, @PathParam("cod-pessoa") Integer codPessoa) {
		AgenciaEntity agencia = agenciaService.findByIdOptional(codPessoa)
				.orElseThrow(() -> new NotFoundException("Agência não encontrada para o código pessoa."))
				.atualizar(
						bancoService.getReference(request.getCodBanco()), 
						request.getCodAgencia(),
						request.getAgenciaCentralizadora(), 
						request.getSituacaoAgenciaRetorno());
		agenciaService.update(agencia);
		return Response.noContent().build();
	}

	@GET
	public List<AgenciaResponse> pesquisar(@BeanParam PaginationRequest paginationRequest, @QueryParam("nome") Optional<String> nome) {
		return agenciaService
				.pesquisar(nome, paginationRequest.getDirection(), paginationRequest.getPage(), paginationRequest.getPageSize())
				.stream()
				.map(AgenciaResponse::new)
				.collect(Collectors.toList());
	}
	
	@DELETE
	@Path(value = "/cod-pessoa/{cod-pessoa}")
	public Response delete(@PathParam("cod-pessoa") Integer codPessoa) {
		if (agenciaService.deleteById(codPessoa))
			return Response.ok().build();
		return Response.status(Status.NOT_FOUND).build();
	}
}
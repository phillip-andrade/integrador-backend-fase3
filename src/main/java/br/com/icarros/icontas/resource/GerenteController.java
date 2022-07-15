package br.com.icarros.icontas.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.icarros.icontas.base.ServerSideResponse;
import br.com.icarros.icontas.dto.request.GerenteRequest;
import br.com.icarros.icontas.dto.request.GerenteRequestPatch;
import br.com.icarros.icontas.dto.response.GerenteResponse;
import br.com.icarros.icontas.dto.response.ListaGerenteResponse;
import br.com.icarros.icontas.exception.GerenteInexistenteException;
import br.com.icarros.icontas.exception.GerenteJaAtivo;
import br.com.icarros.icontas.service.GerenteService;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteService gerenteService;
	
	@PostMapping
	public ResponseEntity<ServerSideResponse<GerenteResponse>>postGerente(@RequestBody @Valid GerenteRequest request,UriComponentsBuilder uriBuilder) throws GerenteJaAtivo{
		GerenteResponse body = gerenteService.createGerente(request);
		URI uri = uriBuilder.path("gerente/{id}").buildAndExpand(body.getId()).toUri();
		ServerSideResponse<GerenteResponse> ssr = ServerSideResponse.<GerenteResponse>builder()
				.dado(body).statusCode(HttpStatus.CREATED.value()).build();
		return new ResponseEntity<ServerSideResponse<GerenteResponse>>(ssr, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ServerSideResponse<GerenteResponse>> putGerente(@RequestBody @Valid GerenteRequest request,@PathVariable Long id) throws GerenteJaAtivo, GerenteInexistenteException{
		GerenteResponse body = gerenteService.updateTotalyGerente(request, id);
		ServerSideResponse<GerenteResponse> ssr = ServerSideResponse.<GerenteResponse>builder()
				.dado(body).statusCode(HttpStatus.OK.value()).build();
		return new ResponseEntity<ServerSideResponse<GerenteResponse>>(ssr, HttpStatus.OK);
	}
	@PatchMapping("/{id}")
	public ResponseEntity<ServerSideResponse<GerenteResponse>> patchGerente(@RequestBody @Valid GerenteRequestPatch request,@PathVariable Long id) throws GerenteInexistenteException, GerenteJaAtivo{
		GerenteResponse body = gerenteService.updatePartityGerente(request, id);
		ServerSideResponse<GerenteResponse> ssr = ServerSideResponse.<GerenteResponse>builder()
				.dado(body).statusCode(HttpStatus.OK.value()).build();
		return new ResponseEntity<ServerSideResponse<GerenteResponse>>(ssr, HttpStatus.OK);
		
	}
	
	@GetMapping
	public List<ListaGerenteResponse> listaGerente(){
		
		return gerenteService.listaGerente();
	}
	
}

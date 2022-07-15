package br.com.icarros.icontas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaGerenteResponse {
	
	private String id;
	private String cpf;
	private String nome;
	private String email;

}

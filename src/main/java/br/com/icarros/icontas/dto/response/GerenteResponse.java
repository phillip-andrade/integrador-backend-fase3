package br.com.icarros.icontas.dto.response;


import lombok.Data;
@Data
public class GerenteResponse {
	private Long id;
    private String cpf;
    private String nome;    
    private String email;

}

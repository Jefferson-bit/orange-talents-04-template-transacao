package br.com.zup.jefferson.transacao.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CartaoRequest {

	@NotBlank(message = "Numero do cartao não pode ser nulo ou vazio")
	private String id;
	@Email(message = "Email invalido")
	@NotBlank(message = "Email não pode ser nulo ou vazio")
	private String email;
	
	public CartaoRequest() {
	}

	public CartaoRequest(@NotNull(message = "ID não pode ser nulo") String id,
			@Email(message = "Email invalido") @NotBlank(message = "Email não pode ser nulo ou vazio") String email) {
		this.id = id;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}

}

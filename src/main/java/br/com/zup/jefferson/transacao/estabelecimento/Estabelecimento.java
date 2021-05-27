package br.com.zup.jefferson.transacao.estabelecimento;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {
	
	private String nome;
	private String cidade;
	private String endereco;
	
	public Estabelecimento(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public Estabelecimento() {
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getNome() {
		return nome;
	}
}
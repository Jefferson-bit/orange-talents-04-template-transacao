package br.com.zup.jefferson.transacao.feignclient;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.jefferson.transacao.cartao.Cartao;
import br.com.zup.jefferson.transacao.estabelecimento.Estabelecimento;
import br.com.zup.jefferson.transacao.evento.EventoDeTransacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private Estabelecimento estabelecimento;
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoResponse() {
	}
	
	public TransacaoResponse(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public TransacaoResponse(EventoDeTransacao entity) {
		this.id = entity.getId();
		this.valor = entity.getValor();
		this.estabelecimento = entity.getEstabelecimento();
		this.cartao = entity.getCartao();
		this.efetivadaEm = entity.getEfetivadaEm();
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

}

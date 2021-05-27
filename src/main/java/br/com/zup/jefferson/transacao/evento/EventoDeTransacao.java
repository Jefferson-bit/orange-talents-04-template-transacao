package br.com.zup.jefferson.transacao.evento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import br.com.zup.jefferson.transacao.cartao.Cartao;
import br.com.zup.jefferson.transacao.estabelecimento.Estabelecimento;

@Entity
public class EventoDeTransacao {
	
	@Id
	private String id;
	private BigDecimal valor;
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "nome", column = @Column(name = "estabelecimento_nome")),
		  @AttributeOverride( name = "cidade", column = @Column(name = "estabelecimento_cidade")),
		  @AttributeOverride( name = "endereco", column = @Column(name = "estabelecimento_endereco")),
		})
	private Estabelecimento estabelecimento;
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "id", column = @Column(name = "cartao_id")),
		  @AttributeOverride( name = "email", column = @Column(name = "cartao_email")),
		})
	private Cartao cartao;
	private LocalDateTime efetivadaEm;
	
	public EventoDeTransacao() {
	}

	public EventoDeTransacao(String id, BigDecimal valor) {
		this.id = id;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}
    
	@PrePersist
	public void createdAt() {
		efetivadaEm = LocalDateTime.now();
	}
	
	public BigDecimal getValor() {
		return valor;
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
    
}
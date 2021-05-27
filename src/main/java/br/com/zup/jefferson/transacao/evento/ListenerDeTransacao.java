package br.com.zup.jefferson.transacao.evento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ListenerDeTransacao {
	
	private static final Logger LOG = LoggerFactory.getLogger(ListenerDeTransacao.class);
	
	@Autowired
	private EventoDeTransacaoRepository eventoDeTransacaoRepository;
	
	@Transactional
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(EventoDeTransacao evento) {
		LOG.info("Analisando a abordagem");
		eventoDeTransacaoRepository.save(evento);
		
		System.out.println("====================================");
		System.out.println("Id: " + evento.getId());
		System.out.println("Valor" + evento.getValor());
		System.out.println("Nome do estabelecimento: " + evento.getEstabelecimento().getNome());
		System.out.println("Cidade do estabelecimento: " + evento.getEstabelecimento().getCidade());
		System.out.println("Endereço do estabelecimento: " + evento.getEstabelecimento().getEndereco());
		System.out.println("Id cartão: " + evento.getCartao().getId());
		System.out.println("Email: " + evento.getCartao().getEmail());
	}

}

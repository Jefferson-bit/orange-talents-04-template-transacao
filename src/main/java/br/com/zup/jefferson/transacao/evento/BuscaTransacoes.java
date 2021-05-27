package br.com.zup.jefferson.transacao.evento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.jefferson.transacao.feignclient.TransacaoResponse;

@RestController
@RequestMapping(value = "/api/transacoes")
public class BuscaTransacoes {

	private EventoDeTransacaoRepository eventoDeTransacaoRepository;
	
	public BuscaTransacoes(EventoDeTransacaoRepository eventoDeTransacaoRepository) {
		this.eventoDeTransacaoRepository = eventoDeTransacaoRepository;
	}

	@GetMapping(value = "/{idCartao}")
	public ResponseEntity  <Page<TransacaoResponse>> buscaUltimasTransacoes(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "size", defaultValue = "5")Integer size,
			@RequestParam(name = "mes", defaultValue = "")Integer mes,
			@PathVariable String idCartao) {
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<EventoDeTransacao> findPage = eventoDeTransacaoRepository
			.buscaPorTransacoes(pageRequest, idCartao, mes);
		Page<TransacaoResponse> pageResponse = findPage.map(obj -> new TransacaoResponse(obj));
		return ResponseEntity.ok(pageResponse);
	}
}

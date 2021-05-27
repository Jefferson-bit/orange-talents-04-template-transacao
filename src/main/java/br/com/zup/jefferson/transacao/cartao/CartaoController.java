package br.com.zup.jefferson.transacao.cartao;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.jefferson.transacao.feignclient.TransacaoFeignClient;
import feign.FeignException;

@RestController
@RequestMapping(value = "/api/cartoes/transacoes")
public class CartaoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CartaoController.class);
	private TransacaoFeignClient transacaoFeignClient;
	
	public CartaoController(TransacaoFeignClient transacaoFeignClient) {
		this.transacaoFeignClient = transacaoFeignClient;
	}

	@PostMapping
	public ResponseEntity<?> estimulaTransacao(@Valid @RequestBody CartaoRequest request) {
		try {
			CartaoRequest cartaoRequest = transacaoFeignClient.consultaTransacao(request);
			return ResponseEntity.ok(cartaoRequest);
		} catch (FeignException ex) {
			LOG.info("Não foi possível completar a chamada para o serviço externo");
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
		}
	}
}

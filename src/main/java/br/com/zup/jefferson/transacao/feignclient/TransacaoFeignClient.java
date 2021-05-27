package br.com.zup.jefferson.transacao.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.zup.jefferson.transacao.cartao.CartaoRequest;

@FeignClient(url = "${url.transacao}", name = "transacao")
public interface TransacaoFeignClient {
	
	@PostMapping(value = "/api/cartoes", consumes = "application/json")
	CartaoRequest consultaTransacao(@RequestBody CartaoRequest request);
}

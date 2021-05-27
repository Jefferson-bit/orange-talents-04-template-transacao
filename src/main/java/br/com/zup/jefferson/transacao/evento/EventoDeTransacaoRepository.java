package br.com.zup.jefferson.transacao.evento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoDeTransacaoRepository extends JpaRepository<EventoDeTransacao, String> {
	
	@Query("SELECT obj FROM EventoDeTransacao obj WHERE obj.cartao.id = :id"
			+ " AND (:mes IS NULL OR MONTH(obj.efetivadaEm) = :mes)")
	Page<EventoDeTransacao> buscaPorTransacoes(Pageable pageable, String id, Integer mes);
}

package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
		// TODO Auto-generated constructor stub
	}

	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {

		TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipoMovimentacao", tipo);

		Double media = query.getSingleResult();
		return media;
	}

}

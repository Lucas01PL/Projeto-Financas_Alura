package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		//Movimentacao movimentacao = manager.find(Movimentacao.class, 130);
		//Conta conta = manager.find(Conta.class, 102);
		Query query = manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes");
		@SuppressWarnings("unchecked")
		List<Conta> contas = query.getResultList();
		manager.close();
		for (Conta conta : contas) {
			System.out.println("Número de Movimentações da conta: "+conta.getMovimentacoes().size());
		}

		
	}
}

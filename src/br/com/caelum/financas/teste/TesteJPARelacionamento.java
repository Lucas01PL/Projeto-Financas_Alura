package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Lucas Pereira de Lima");
		conta.setBanco("HSDBC");
		conta.setNumero("123345");
		conta.setAgencia("321");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(123.90));
		movimentacao.setConta(conta);
		EntityManager manager = new JPAUtil().getEntityManager();
		
		double inicio = System.currentTimeMillis();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		double fim = System.currentTimeMillis();
	    System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}

}

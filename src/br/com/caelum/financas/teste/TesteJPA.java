package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Lucas Pereira");
		conta.setBanco("HSDBC");
		conta.setNumero("123345");
		conta.setAgencia("321");
		EntityManager manager = new JPAUtil().getEntityManager();
		
		double inicio = System.currentTimeMillis();
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		double fim = System.currentTimeMillis();
	    System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}

}

package aplicacao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Compra;
import model.Pessoa;
import controllers.CompraJPAController;
import controllers.PessoaJPAController;


//GUILHERME LOPES 				316346

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	      // Criando  pessoas
        Pessoa pessoa = new Pessoa(1, "usuario123", "senha123", "usuario123@email.com", "João da Silva");
        Pessoa pessoa2 =new Pessoa (2, "usuario456", "senha456", "usuario456@email.com", "Gabriel da Silva");
        // Criando compras para as pessoas
        Compra compra1 = new Compra();
        compra1.setId_compra(1);
        compra1.setValor("100.00");
        compra1.setData(new Date());
        compra1.setPagamento("Cartão de crédito");
        compra1.setRecebido(true);
        compra1.setCliente(pessoa);
        Compra compra2 = new Compra();
        compra2.setId_compra(2);
        compra2.setValor("150.00");
        compra2.setData(new Date());
        compra2.setPagamento("Boleto bancário");
        compra2.setRecebido(false);
        compra2.setCliente(pessoa2);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unilins-jpa");
		EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = et.getTransaction();
        transaction.begin();

        em.persist(pessoa);
        em.persist(compra1);
        em.persist(compra2);

        transaction.commit();

        Pessoa pessoaRecuperada = em.find(Pessoa.class, 1);
        System.out.println("Nome da pessoa recuperada: " + pessoaRecuperada.getNome());

        // Imprimindo informações das compras
        System.out.println("Compras da pessoa:");
        for (Compra compra : pessoaRecuperada.getCompras()) {
            System.out.println("ID da compra: " + compra1.getId_compra());
            System.out.println("Valor da compra: R$" + compra1.getValor());
            System.out.println("Data da compra: " + compra1.getData());
            System.out.println();
        }
        
        
        Pessoa pessoaRecuperada2 = em.find(Pessoa.class, 2);
        System.out.println("Nome da pessoa recuperada: " + pessoaRecuperada2.getNome());

        // Imprimindo informações das compras
        System.out.println("Compras da pessoa:");
        for (Compra compra : pessoaRecuperada2.getCompras()) {
            System.out.println("ID da compra: " + compra2.getId_compra());
            System.out.println("Valor da compra: R$" + compra2.getValor());
            System.out.println("Data da compra: " + compra2.getData());
            System.out.println();
        }
    
        em.close();
        emf.close();
    

	}

}

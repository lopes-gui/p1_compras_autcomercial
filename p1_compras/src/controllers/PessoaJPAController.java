package controllers;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import java.util.List;
import model.Pessoa;

public class PessoaJPAController {
    private EntityManagerFactory emf;

    public PessoaJPAController() {
        emf = Persistence.createEntityManagerFactory(""); 
    }

    public void create(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(pessoa);
        et.commit();
        em.close();
    }

    public void edit(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(pessoa);
        et.commit();
        em.close();
    }

    public void destroy(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.remove(pessoa);
        }
        et.commit();
        em.close();
    }

    public List<Pessoa> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = query.getResultList();
        em.close();
        return pessoas;
    }

    public Pessoa findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = em.find(Pessoa.class, id);
        em.close();
        return pessoa;
    }
}
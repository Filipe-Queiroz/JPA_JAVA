package main.java.dao;

import main.java.br.com.fqueiroz.domain.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AcessorioDao implements IAcessorioDao {


    @Override
    public Acessorio cadastrar(Acessorio ace) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(ace);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return ace;
    }
}

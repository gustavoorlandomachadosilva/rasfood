package br.com.rasmoo.restaurante.dao;

import br.com.rasmoo.restaurante.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    CRUD
    *C = Create
    *R = Read
    *U = Update
    *D = Delete
     */
    public void cadastrar(final Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade Cadastrada :" + cardapio);
    }
    public Cardapio consultar(Integer id){
       return this.entityManager.find(Cardapio.class,id);
    }
    public void atualizar(final Cardapio cardapio){
        entityManager.merge(cardapio);
    }
    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
    public List<Cardapio> consultarTodos(){
        try{
            String jpql = "SELECT c FROM Cardapio c ";
            return this.entityManager.createQuery(jpql,Cardapio.class).getResultList();
        }
        catch (Exception e){
            return Collections.emptyList();
        }

    }
    public List<Cardapio> consultarPorValor(final BigDecimal valorInserido){
        try{
            String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
            return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("valor",valorInserido).getResultList();
        }
        catch (Exception e){
            return Collections.emptyList();
        }

    }
    public Cardapio consultarPorNome(final String nomeInserido){
        try {
            String jpql = "SELECT c FROM Cardapio c Where UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("nome",nomeInserido).getSingleResult();
        }
        catch (Exception e){
            return  null;
        }

    }
}

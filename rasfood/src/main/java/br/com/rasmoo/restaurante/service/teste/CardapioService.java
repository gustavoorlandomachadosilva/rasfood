package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args){
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Acompanhado de camarão, polvo e mariscos");
        risoto.setValor(BigDecimal.valueOf(35.50));
        risoto.setDisponivel(true);

        Cardapio parmegiana = new Cardapio();
        risoto.setNome("Parmegiana de frango");
        risoto.setDescricao("Macarrão ao molho tomate com frango empanda e queijo");
        risoto.setValor(BigDecimal.valueOf(25));
        risoto.setDisponivel(true);

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        entityManager.getTransaction().begin();
        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(parmegiana);
        cardapioDao.consultarTodos().forEach(elemento -> System.out.println("O prato consultado foi: " + elemento));
        System.out.println("Lista de produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(25)) );
        System.out.println("O produto pesquisado foi: " + cardapioDao.consultarPorNome("parmegiana de frango"));
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

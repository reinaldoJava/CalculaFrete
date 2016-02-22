package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.model.Mapa;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	@PersistenceContext(unitName="rotasPU")
    private EntityManager entityManager;
	
	@Override
	public void adicionar(Mapa rota) {
		// TODO Auto-generated method stub
		entityManager.persist(rota);
	}

	@Override
	public void remover(Mapa rota) {
		// TODO Auto-generated method stub
		entityManager.remove(rota);
	}

	@Override
	public void atualizar(Mapa rota) {
		// TODO Auto-generated method stub
		entityManager.merge(rota);
	}

	@Override
	public List<Mapa> list() {
		return entityManager.createQuery("FROM " + Mapa.class.getName()).getResultList();
	}

	
	
}

package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.model.MapaBO;

@Repository
public class ClienteDAOImpl implements ClienteDAO{

	@PersistenceContext(unitName="rotasPU")
    private EntityManager entityManager;
	
	@Override
	public void adicionar(MapaBO rota) {
		// TODO Auto-generated method stub
		entityManager.persist(rota);
	}

	@Override
	public void remover(MapaBO rota) {
		// TODO Auto-generated method stub
		entityManager.remove(rota);
	}

	@Override
	public void atualizar(MapaBO rota) {
		// TODO Auto-generated method stub
		entityManager.merge(rota);
	}

	@Override
	public List<MapaBO> list() {
		return entityManager.createQuery("FROM " + MapaBO.class.getName()).getResultList();
	}

	
	
}

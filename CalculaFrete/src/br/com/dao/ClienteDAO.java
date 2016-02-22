package br.com.dao;

import java.util.List;

import br.com.model.Mapa;

public interface ClienteDAO {

	void adicionar(Mapa rota);
	void remover(Mapa rota);
	void atualizar(Mapa rota);
	List<Mapa> list();
	
}

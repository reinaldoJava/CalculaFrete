package br.com.dao;

import java.util.List;

import br.com.model.MapaBO;

public interface ClienteDAO {

	void adicionar(MapaBO rota);
	void remover(MapaBO rota);
	void atualizar(MapaBO rota);
	List<MapaBO> list();
	
}

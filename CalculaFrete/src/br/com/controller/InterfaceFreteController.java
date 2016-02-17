package br.com.controller;

import java.util.List;

import br.com.model.DadosFrete;
import br.com.model.Mapa;


public interface InterfaceFreteController {

	void nextRota(Mapa rota);
	List<Mapa> calcularRota(DadosFrete dadosFrete);
	Mapa calcularRotaPorPreco(List<Mapa> rotas);
	
}

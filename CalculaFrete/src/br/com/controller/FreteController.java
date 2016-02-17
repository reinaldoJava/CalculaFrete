package br.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.dao.ClienteDAO;
import br.com.dao.ClienteDAOImpl;
import br.com.model.DadosFrete;
import br.com.model.Mapa;

public class FreteController implements InterfaceFreteController{

	private Mapa rota;

	@Override
	public void nextRota(Mapa rota) {	
		 this.rota = rota;
	}
	
	@Autowired
	private ClienteDAO dao;
	
	
	public List<Mapa> mapas = new ArrayList<Mapa>();
	 {
		
		Mapa mapa1 = new Mapa("São Paulo 1","A","B",10.0);
		Mapa mapa2 = new Mapa("São Paulo 2","B","D",15.0);
		Mapa mapa3 = new Mapa("São Paulo 3","A","C",20.0);
		Mapa mapa4 = new Mapa("São Paulo 4","C","D",30.0);
		Mapa mapa5 = new Mapa("São Paulo 5","B","E",50.0);
		Mapa mapa6 = new Mapa("São Paulo 6","D","E",30.0);
		Mapa mapa7 = new Mapa("São Paulo 7","E","A",60.0);
		mapas.add(mapa1);
		mapas.add(mapa2);
		mapas.add(mapa3);
		mapas.add(mapa4);
		mapas.add(mapa5);
		mapas.add(mapa6);
		mapas.add(mapa7);
	}

	@Override
	public List<Mapa> calcularRota(DadosFrete dadosFrete) {
	
		return null;
	}

	@Override
	public Mapa calcularRotaPorPreco(List<Mapa> rotas) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

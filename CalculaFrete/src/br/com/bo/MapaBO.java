package br.com.bo;

import java.util.List;

public class MapaBO implements Comparable<MapaBO>{
	
	private String nome;
	private Double menorValor = Double.POSITIVE_INFINITY;
	private MapaBO mapaBOAnterior;
	private List<RotaBO> rotas;
	
	public MapaBO(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int compareTo(MapaBO o) {
		// TODO Auto-generated method stub
		return Double.compare(getMenorValor(), o.getMenorValor());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getMenorValor() {
		return menorValor;
	}

	public void setMenorValor(Double menorValor) {
		this.menorValor = menorValor;
	}

	public MapaBO getMapaBOAnterior() {
		return mapaBOAnterior;
	}

	public void setMapaBOAnterior(MapaBO mapaBOAnterior) {
		this.mapaBOAnterior = mapaBOAnterior;
	}

	public List<RotaBO> getRotas() {
		return rotas;
	}

	public void setRotas(List<RotaBO> rotas) {
		this.rotas = rotas;
	}
	
	

}

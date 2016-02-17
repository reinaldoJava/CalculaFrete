package br.com.model;

public class Rota {

	public final Mapa mapa;
    public final Double distancia;
    public Rota(Mapa argTarget, Double argWeight){ 
    	mapa = argTarget; 
    	distancia = argWeight; 
    }
}

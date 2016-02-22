package br.com.bo;

public class RotaBO {

	private MapaBO mapaBO;
    private Double distanciaKM;
    
    public RotaBO(MapaBO mapaBO, Double valor){ 
    	this.setMapaBO(mapaBO); 
    	this.setValor(valor); 
    }

	public MapaBO getMapaBO() {
		return mapaBO;
	}

	public void setMapaBO(MapaBO mapaBO) {
		this.mapaBO = mapaBO;
	}

	public Double getValor() {
		return distanciaKM;
	}

	public void setValor(Double valor) {
		this.distanciaKM = valor;
	}
}

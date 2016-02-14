package br.com.model;

public class Mapa {

	private Long id;
	private String nome;
	private String origem;
	private String destino;
	private Double distanciaKM;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getDistanciaKM() {
		return distanciaKM;
	}
	public void setDistanciaKM(Double distanciaKM) {
		this.distanciaKM = distanciaKM;
	}
	public Mapa(String nome, String origem, String destino, Double distanciaKM) {
		this.nome = nome;
		this.origem = origem;
		this.destino = destino;
		this.distanciaKM = distanciaKM;
	}	
}
